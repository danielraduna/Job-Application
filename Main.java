package com.company;

 class Main {
     public static void main(String args[])
     {
         User user = new User();
         User user1 = new User();
         User user2 = new User();
         user.social_network.add(user1);
         user1.social_network.add(user2);
         System.out.println(user.getDegreeInFriendship(user2));


     }
 }
