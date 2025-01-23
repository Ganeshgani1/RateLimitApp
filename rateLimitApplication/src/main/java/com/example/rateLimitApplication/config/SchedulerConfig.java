package com.example.rateLimitApplication.config;

import com.example.rateLimitApplication.entity.User;
import com.example.rateLimitApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    private UserRepository userRepo;
   // public static ConcurrentHashMap<String,Integer> tokens=new ConcurrentHashMap<>();
   public static Map<String,Integer> tokens=new HashMap<>();
    public static Map<String,Integer> userTokens=new HashMap<>();

    //public static ConcurrentHashMap<String,Integer> userTokens=new ConcurrentHashMap<>();

    @Scheduled(fixedDelay = 5,timeUnit = TimeUnit.SECONDS)
    public void refillTokens(){
        //System.out.println("Print after every second");
     tokens.put("maxTps",50);
        List<User> userList=userRepo.findAll();
        userList.stream().forEach(s->{
            userTokens.put(s.getUserName(),s.getTps().intValue());
        });
    }
}
