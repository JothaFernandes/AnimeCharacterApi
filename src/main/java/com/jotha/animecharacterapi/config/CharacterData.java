package com.jotha.animecharacterapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.jotha.animecharacterapi.constants.CharacterConstant.ENDPOINT_DYNAMO;
import static com.jotha.animecharacterapi.constants.CharacterConstant.REGION_DYNAMO;

public class CharacterData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration( new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO)).build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("tb_AnimeCharacter");

        Item character = new Item().withPrimaryKey("id","2")
                .withString("name", "Son Goku")
                .withString("anime", "Dragon Ball")
                .withString("race", "sayajin");

        Item character2 = new Item().withPrimaryKey("id","3")
                .withString("name", "Saitama")
                .withString("anime", "One Punch Man")
                .withString("race", "human");

        Item character3 = new Item().withPrimaryKey("id","4")
                .withString("name", "Zeno-Sama")
                .withString("anime", "Dragon Ball Super")
                .withString("race", "god");

        Item character4 = new Item().withPrimaryKey("id","5")
                .withString("name", "Medaka Kurokami")
                .withString("anime", "Medaka Box")
                .withString("race", "human");



        PutItemOutcome outcome1 = table.putItem(character);
        PutItemOutcome outcome2 = table.putItem(character2);
        PutItemOutcome outcome3 = table.putItem(character3);
        PutItemOutcome outcome4 = table.putItem(character4);
    }
}





