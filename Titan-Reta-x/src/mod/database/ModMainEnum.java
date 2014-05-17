package mod.database;

public enum ModMainEnum {
	ModMain("mod_main","mod_tagid", "mod_price", "mod_model", "mod_lasttapped", "mod_id", "mod_description", "mod_comments", "mod_category");
	
	public String TableName,TagID,Price,Model,LastTapped,ID,Desription,Comments,Category;
	
	private ModMainEnum(String TableName,String TagID,String Price,String Model,String LastTapped,String ID,String Desription,String Comments,String Category){
		this.TableName=TableName;
		this.TagID=TagID;
		this.Price=Price;
		this.Model=Model;
		this.LastTapped=LastTapped;
		this.ID=ID;
		this.Desription=Desription;
		this.Comments=Comments;
		this.Category=Category;
	}
}
