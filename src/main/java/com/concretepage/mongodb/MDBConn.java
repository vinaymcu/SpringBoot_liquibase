package com.concretepage.mongodb;

import com.concretepage.controller.ArticleController;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MDBConn {
    private static final Logger logger = LoggerFactory.getLogger(MDBConn.class);
    public static void main(String args[]){

        // get all database names
        getAllDatbasesList();
        // get all collection
        //getAllCollections();

        //insertIntoCollection();
        // get documensts
       // insertIntoCollections();
       // getCollectionProperty();
        getDocuments();
       // deleteOneDocument();
        //insertIntoCollection();
    }

    private static void getCollectionProperty(){
        MongoDatabase database = getMongoClient().getDatabase("mydb");
        MongoCollection collection = database.getCollection("mycol");
        System.out.println("count>"+collection.count());
        System.out.println("WriteConcern>>"+collection.getWriteConcern());
        System.out.println("getReadConcern>>"+collection.getReadConcern().asDocument());
    }

    private static void getDocuments(){

        MongoDatabase database = getMongoClient().getDatabase("mydb");
        MongoCollection collection = database.getCollection("mycol");
        FindIterable<Document> docs = collection.find();

        for (Document doc : docs) {
            System.out.println(doc);
           // System.out.println(doc.getString("name1"));
        }

//        Bson query = eq("name", "mkyong1");
//        FindIterable findI= collection.find(query);
//        System.out.println(findI.first());


        BasicDBObject query1 = new BasicDBObject();
        query1.put("name", "mkyong");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "mkyong-updated");

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        collection.updateOne(query1, updateObj);

        FindIterable<Document> docs1 = collection.find();

        for (Document doc1 : docs1) {
            System.out.println(doc1);
            //System.out.println(doc1.getString("name1"));
        }
    }

    private static void insertIntoCollection() {

        MongoDatabase database = getMongoClient().getDatabase("mydb");
        MongoCollection collection = database.getCollection("mycol");



        Document document = new Document();
        document.put("name", "vinay");
        document.put("age", 23);
       // document.put("createdDate", new Date());
        collection.insertOne(document);

       // collection.updateOne()

    }


    private static void insertIntoCollections() {

        MongoDatabase database = getMongoClient().getDatabase("mydb");
        MongoCollection collection = database.getCollection("mycol");
        List<Document> list=new ArrayList<>();
        Document document1 = new Document();
        document1.put("name", "mkyong");
        document1.put("age", 30);
        document1.put("createdDate", new Date());
        list.add(document1);
        Document document2 = new Document();
        document2.put("name1", "mkyong1");
        document2.put("age1", 20);
        document2.put("createdDate", new Date());
       // table.insertOne(document);
        list.add(document2);
        collection.insertMany(list);
    }

    /**
     * getMongoClient
     * @return
     */
    private static MongoClient getMongoClient() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
        return new MongoClient(connectionString);
    }

    /**
     *
     * @param
     */
    private static void getAllDatbasesList(){

        List<String> dbs = getMongoClient().getDatabaseNames();
        for(String db : dbs){
            System.out.println("DB:::"+db);
        }
    }
    private static void getAllCollections(){

        MongoDatabase database = getMongoClient().getDatabase("mydb");
        MongoIterable<String> collections = database.listCollectionNames();
        for(String str:collections){
            System.out.println("collections :::"+str);
        }
    }

    private static void deleteOneDocument() {
        MongoDatabase database = getMongoClient().getDatabase("mydb");
        MongoCollection collection = database.getCollection("mycol");
        Bson query = eq("name", "mkyong1");


        DeleteResult result = collection.deleteMany(query);
        if (result.wasAcknowledged()) {
            logger.info("Single Document deleted successfully \nNo of Document Deleted : " + result.getDeletedCount());
        }
    }

    private static void updateDocument(){
        MongoDatabase database = getMongoClient().getDatabase("mydb");
        MongoCollection collection = database.getCollection("mycol");

    }
    private void printData(){
        System.out.println();
    }
}
