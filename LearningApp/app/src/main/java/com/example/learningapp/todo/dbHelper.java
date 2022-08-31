package com.example.learningapp.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    public static final String TODO_NAME = "TodoName";
    public static final String TODO_DESC = "TodoDesc";
    public static final String TODO_TABLE = "TodoTable";
    private static final String ToDo_ID = "_id";

    public dbHelper(@Nullable Context context) {
        super(context, "MyDB.db" , null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CreateTableStat="CREATE TABLE " + TODO_TABLE
                +" (_id integer primary key autoincrement, " + TODO_NAME + " text, "
                + TODO_DESC + " text )";
//        String CreateTableStat = "create table " + TODO_TABLE + "(" + _ID
//                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TODO_NAME + " TEXT NOT NULL, " + TODO_DESC + " TEXT);";


        sqLiteDatabase.execSQL(CreateTableStat);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TODO_TABLE);
        onCreate(sqLiteDatabase);
    }
    public void  addTodo(todoModel todo){
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put(TODO_NAME, todo.getName());
        cv.put(TODO_DESC, todo.getDescription());

//        db.insert(TODO_TABLE, null, cv);
        db.insert(TODO_TABLE, null, cv);


        db.close();
        //NullCoumnHack
        //long insert =
        //if (insert == -1) { return false; }
        //else{return true;}
    }
    public ArrayList<todoModel> getAllTodos() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TODO_TABLE, null);

        ArrayList<todoModel> todoArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                todoArrayList.add(new todoModel(cursorCourses.getString(1),
                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return todoArrayList;
    }
    public void deleteRow(String Name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from "+TODO_TABLE+" where "+TODO_NAME+" =\""+Name+"\";");
        db.close();
    }
    public void updateRow(String Oname,String Desc){
        SQLiteDatabase db = this.getWritableDatabase();

//        String strSQL = "UPDATE "+TODO_TABLE+" SET "+TODO_DESC+" = "+Desc+" WHERE "+ TODO_NAME+" = "+ Oname;
        db.execSQL("UPDATE "+TODO_TABLE+" SET TodoDesc = "+"'"+Desc+"' "+ "WHERE TodoName = "+"'"+Oname+"'");


//        String strSQL = "UPDATE myTable SET Column1 = someValue WHERE columnId = "+ someValue;


//        db.execSQL(strSQL);
        db.close();
    }




}
