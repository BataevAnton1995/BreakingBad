package com.breakingbad.data.managers.network.api;

public class Data {
     public String password;
     public String socialIdentifier;
     public String email;

     public Data(String password, String socialIdentifier, String email) {
          this.password = password;
          this.socialIdentifier = socialIdentifier;
          this.email = email;
     }
}
