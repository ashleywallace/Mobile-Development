package exam.travelnotesmanager.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class NoteTable {
	// Database table
	  public static final String TABLE_NOTE = "note";
	  public static final String COLUMN_ID = "_id";
	  public static final String COLUMN_TITLE = "title";
	  public static final String COLUMN_ADDRESS = "address";
	  public static final String COLUMN_DESCRIPTION = "description";
	  public static final String COLUMN_VISITDATE = "visit_date";
	  public static final String COLUMN_VISITAGAIN = "visit_again";

	  // Database creation SQL statement
	  private static final String DATABASE_CREATE = "create table " 
	      + TABLE_NOTE
	      + "(" 
	      + COLUMN_ID + " integer primary key autoincrement, " 
	      + COLUMN_TITLE + " text not null, " 
	      + COLUMN_ADDRESS + " text not null," 
	      + COLUMN_DESCRIPTION + " text," 
	      + COLUMN_VISITDATE + " date," 
	      + COLUMN_VISITAGAIN + " integer not null" 
	      + ");";

	  public static void onCreate(SQLiteDatabase database) {
	    System.out.println("DATABASE CCREATING");
		  database.execSQL(DATABASE_CREATE);
	    
	    
	  }

	  public static void onUpgrade(SQLiteDatabase database, int oldVersion,
	      int newVersion) {
	    Log.w(NoteTable.class.getName(), "Upgrading database from version "
	        + oldVersion + " to " + newVersion
	        + ", which will destroy all old data");
	    database.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
	    onCreate(database);
	  }

}
