package com.example.rateLimitApplication.config;

import com.example.rateLimitApplication.entity.User;
import com.example.rateLimitApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class RateLimitConfiguration {

    //We can use the concurrent hashMap and synchronized block for thread based execution.
//    private ConcurrentHashMap<String, Integer> maxTransactionsPerSecond=SchedulerConfig.tokens;
//    private ConcurrentHashMap<String, Integer> userTokens=SchedulerConfig.userTokens;

    private Map<String, Integer> maxTransactionsPerSecond=SchedulerConfig.tokens;
    private Map<String, Integer> userTokens=SchedulerConfig.userTokens;


    public void allowTransaction(Optional<User> user) throws Exception {

        //synchronized (userTokens) {
            int tokens = userTokens.get(user.get().getUserName());
            System.out.println(tokens +" the tokens of "+user.get().getUserName());
            if (tokens > 0 && maxTransactionsPerSecond.get("maxTps") > 0) {
                maxTransactionsPerSecond.put("maxTps", maxTransactionsPerSecond.get("maxTps")-1);
                userTokens.put(user.get().getUserName(), tokens - 1);
            } else {
                throw new Exception("Rate limit exceeded for user: " + user.get().getUserName());
            }
       // }
    }
}
