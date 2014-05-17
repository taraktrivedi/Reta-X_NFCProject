package mod.database;

public enum ReviewsTableEnum {
	Reviews("reviews","Name","Rating","Review");
	
	 public String TableName, Name,Rating,Review;
	 
	 private ReviewsTableEnum(String TableName,String Name,String Rating,String Review){
		 this.TableName=TableName;
		 this.Name=Name;
		 this.Rating=Rating;
		 this.Review=Review;
	 }
	 
}
