package my.company;

public record MessageData(String dataId) {
  public String getDataId(){
    return dataId();
  }
}
