package Utilities;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;

	public class ScenarioContext {

	    private List<Map<String, Object>> customerList;
	    private List<Map<String, Object>> jobLogSummaryList;
	    private List<Map<String, Object>> currentJobLogSummaryList;
	    private List<Map<String, Object>> existingTicketsList;

	    public ScenarioContext() {
	        customerList = new ArrayList<>();
	        jobLogSummaryList = new ArrayList<>();
	        currentJobLogSummaryList = new ArrayList<>();
	        existingTicketsList = new ArrayList<>();
	    }

	    public List<Map<String, Object>> getCustomerList() {
	        return customerList;
	    }

	    public void setCustomerList(Map<String, Object> dataMap) {
	        customerList = new ArrayList<>();
	        customerList.add(dataMap);
	    }

	    public List<Map<String, Object>> getExistingTicketsList() {
	        return existingTicketsList;
	    }

	    public void setExistingTicketsList(Map<String, Object> dataMap) {
	        existingTicketsList = new ArrayList<>();
	        existingTicketsList.add(dataMap);
	    }

	    public List<Map<String, Object>> getJobLogSummaryList() {
	        return jobLogSummaryList;
	    }

	    public void setJobLogSummaryList(List<Map<String, Object>> dataList) {
	        jobLogSummaryList = new ArrayList<>();
	        jobLogSummaryList.addAll(dataList);
	    }

	    public List<Map<String, Object>> getCurrentJobLogSummaryList() {
	        return currentJobLogSummaryList;
	    }

	    public void setCurrentJobLogSummaryList(List<Map<String, Object>> dataList) {
	        currentJobLogSummaryList = new ArrayList<>();
	        currentJobLogSummaryList.addAll(dataList);
	    }
	}

