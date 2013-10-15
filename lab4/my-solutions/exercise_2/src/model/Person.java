package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")

@XmlType(propOrder = { "age", "address" })
public class Person {

  private String nome;
  private int age;
  private String address;

  @XmlAttribute
  public String getNome() {
    return nome;
  }
  
  public void setNome(String value) {
    this.nome = value;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
} 