package Utilities;


	import com.amazonaws.auth.AWSCredentials;
	import com.amazonaws.auth.AWSStaticCredentialsProvider;
	import com.amazonaws.auth.BasicAWSCredentials;
	import com.amazonaws.regions.Regions;
	import com.amazonaws.services.s3.AmazonS3;
	import com.amazonaws.services.s3.AmazonS3ClientBuilder;
	import com.amazonaws.services.s3.model.AmazonS3Exception;
	import com.amazonaws.services.s3.model.GetObjectRequest;
	import com.amazonaws.services.s3.model.S3Object;
	import org.apache.log4j.Logger;
	import org.json.simple.parser.ParseException;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.*;

	public class S3Util {

	    private Logger log = Logger.getLogger(S3Util.class);
	    private ConfigReader properties = new ConfigReader();
	    private Properties prop = properties.init_properties();

	    public List<Map<String, Object>> downloadFileFromS3BucketAsMap(String s3Bucket, String filePath)
	            throws IOException, AmazonS3Exception, ParseException {
	        List<String> headerLabel = new ArrayList<String>();
	        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	        Map<String, Object> dataMap;
	        String odFileHeader = prop.getProperty("odFileHeader");
	        String dbEnvironment = prop.getProperty("dbEnvironment");
	        String bucketName = s3Bucket.replace("environment", dbEnvironment);
	        log.info("S3 Bucket Name: " + bucketName);
	        log.info("S3 File Path: " + filePath);

	        if (this.fileExistInS3(bucketName, filePath)) {
	            AmazonS3 s3Client = s3ClientBuilder();
	            S3Object fileObject = s3Client.getObject(new GetObjectRequest(bucketName, filePath));
	            InputStream fileInputstream = fileObject.getObjectContent();
	            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputstream));
	            String currentLine;
	            boolean headerCheck = true;
	            while ((currentLine = fileReader.readLine()) != null) {
	                dataMap = new LinkedHashMap<String, Object>();
	                if (headerCheck == true && filePath.contains("od.txt")) {
	                    for (String header : odFileHeader.split(","))
	                        headerLabel.add(header);
	                    headerCheck = false;
	                }
	                if (headerCheck == true) {
	                    if (currentLine.contains(",")) {
	                        for (String header : currentLine.split(","))
	                            headerLabel.add(header);
	                    } else {
	                        for (String header : currentLine.split("\t"))
	                            headerLabel.add(header);
	                    }
	                    headerCheck = false;
	                } else {
	                    int h = 0;
	                    if (currentLine.contains(",")) {
	                        for (String value : currentLine.split(",")) {
	                            dataMap.put(headerLabel.get(h), value);
	                            h++;
	                        }
	                    } else {
	                        for (String value : currentLine.split("\t")) {
	                            dataMap.put(headerLabel.get(h), value);
	                            h++;
	                        }
	                    }
	                    dataList.add(dataMap);
	                }
	            }
	        }
//	        log.info("S3 File Content: ");
//	        for (Map<String, Object> data : dataList)
//	            log.info(data.toString());
	        return dataList;
	    }

	    public List<String> downloadFileFromS3BucketAsList(String s3Bucket, String filePath)
	            throws IOException, AmazonS3Exception, ParseException {
	        List<String> dataList = new ArrayList<String>();
	        String dbEnvironment = prop.getProperty("dbEnvironment");
	        String bucketName = s3Bucket.replace("environment", dbEnvironment);
	        log.info("S3 Bucket Name: " + bucketName);
	        log.info("S3 File Path: " + filePath);

	        if (this.fileExistInS3(bucketName, filePath)) {
	            AmazonS3 s3Client = s3ClientBuilder();
	            S3Object fileObject = s3Client.getObject(new GetObjectRequest(bucketName, filePath));
	            InputStream fileInputstream = fileObject.getObjectContent();
	            BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputstream));
	            String currentLine;
	            while ((currentLine = fileReader.readLine()) != null) {
	                dataList.add(currentLine);
	            }
	        }
//	        log.info("S3 File Content: ");
//	        for (String data : dataList)
//	            log.info(data);
	        return dataList;
	    }

	    public Boolean fileExistInS3(String bucketName, String filePath) throws IOException, AmazonS3Exception {
	        boolean objectExists = false;
	        String dbEnvironment = prop.getProperty("dbEnvironment");
	        AmazonS3 s3Client = s3ClientBuilder();
	        objectExists = s3Client.doesObjectExist(bucketName, filePath);
	        if (objectExists)
	            log.info(filePath + " file exists in " + bucketName + " bucket");
	        else
	            log.info(filePath + " file doesn't exist in " + bucketName + " bucket");
	        return objectExists;
	    }

	    private AmazonS3 s3ClientBuilder() throws IOException, AmazonS3Exception {
	        String accessKey = prop.getProperty("s3AccessKey");
	        String secretKey = prop.getProperty("s3SecretKey");

	        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
	        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.US_EAST_1)
	                .build();
	        return s3Client;
	    }

	}

