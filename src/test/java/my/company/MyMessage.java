package my.company;

public record MyMessage(String objectUid, String country, MessageData data) {
  public String getObjectUid(){
    return objectUid();
  }
  public String getCountry(){
    return country();
  }
  public MessageData getData(){
    return data();
  }
}
