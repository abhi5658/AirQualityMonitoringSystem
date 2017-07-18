package com.tcs.aqi.beans;

public class Emp {
private String state;
private String city;
private String location;
private float  pm10,pm2dot5,no2,o3,co,so2,nh3,pb;

public Emp() {}


public String getState(){
	return state;
}
public void setState (String state){
	this.state = state;
}
public void setCity (String city){
	this.city = city;
}
public String getCity (){
	return city;
}
public void setLocation (String location){
	this.location = location;
}
public String getLocation (){
	return location;
}
public void setpm10 (float pm10)
{
	this.pm10 = pm10;
}
public float getpm10 ()
{
	return pm10;
}
public void setpm2dot5 (float pm2dot5)
{
	this.pm2dot5 = pm2dot5;
}
public float getpm2dot5 ()
{
	return pm2dot5;
}
public void setno2 (float no2)
{
	this.no2 = no2;
}
public float getno2 ()
{
	return (float) no2;
}
public void seto3 (float o3)
{
	this.o3 = o3;
}
public float geto3 ()
{
	return (float) o3;
}
public void setco (float co)
{
	this.co = co;
}
public float getco ()
{
	return (float) co;
}
public void setso2 (float so2)
{
	this.so2 = so2;
}
public float getso2 ()
{
	return (float) so2;
}
public void setnh3 (float nh3)
{
	this.nh3 = nh3;
}
public float getnh3 ()
{
	return (float) nh3;
}
public void setpb (float pb)
{
	this.pb = pb;
}
public float getpb ()
{
	return (float) pb;
}
}
