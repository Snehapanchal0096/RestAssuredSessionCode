package Lesson_29_HandlingComplexNestedJSONPOJO;

public class APIResponse {
	private String status;
	private UserData userdata;
	private Meta meta;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserData getUserdata() {
		return userdata;
	}
	public void setUserdata(UserData userdata) {
		this.userdata = userdata;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	

}
