package com.ghazitrader.ghazimart.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Configuration {
    @Value("${jsa.aws.access_key_id}")
    private String awsId;

    @Value("${jsa.aws.secret_access_key}")
    private String awsKey;

    @Value("${jsa.s3.region}")
    private String region;

    @Bean
    public AmazonS3 s3Client(){
        final BasicAWSCredentials awsCredentials= new BasicAWSCredentials(awsId, awsKey);
        final AmazonS3 amazonS3= AmazonS3ClientBuilder.standard()
        .withRegion(Regions.fromName(region))
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
        .build();
        return amazonS3;

    }

}
