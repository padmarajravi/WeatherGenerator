This project is to generate realistic weather data over a large area based on a toy environment considering various geographic and topographic features.

Four attributes that will be generated as weather data are

1)Condition - specified by SUNNY,RAINY or SNOWY
2)Temperature - A double value
3)Pressure - A double value
4)Humidity - An integer value

For the scope of this project , two geographic features and one topographic feature was considered. Features considered were distance to equator , distance to closest water body and elevation above sea level.

To get the geographic and topographic features of latitude- longitude combination , a shape file from natural earth and a DEM file from NASA website is used.Java Geotools API is used to extract this information from the source. 

From the initial reading , 

These four factors decide the average temperature of a region
Factors 

1)Places near to equator are hotter and near to poles are colder
2)Rises from morning to noon and then goes down till next morning
3)Goes down as the sea level increases

Factors affecting pressure

1)Altitude - Goes down as altitude goes up.The decrease in pressure is about l cm of
mercury for every 110 m of ascent. 
2)Temperature - Goes down as temperature goes up
3)Humidity - Goes down as humidity goes up

Factors affecting humidity

1)Temperature
2)Closeness to water bodies

A brief description of the approaches considered to complete the task is provided below. 

Approach 1 - Naive Approach
==================================================

From past data gradients of all these factors can be deduced and used to create realistic weather estimates.

For building a realistic temperature value, a builder approach has been adopted. First the pole to equator temperature gradient was considered and a value was generated based on that. Then a seasonal component was added. Then a diurnal temperature variation component is added and then at last an elevation dependent component is subtracted.

After building a reliable estimate of temperature , that estimates is used to build a humidity estimate. Relative humidity is the ratio of actual water vapor density and saturation water vapor density. Saturation water vapor density is calculated based on the temperature using an empirical formula. An approximate measure of actual water vapor density is derived using distance to closest water body. A gradient value has been assumed to accomplish this. This was defined based on past humidity data at dry areas and coastal regions.

Reference : http://hyperphysics.phy-astr.gsu.edu/hbase/kinetic/relhum.html

Temeperature and elevation is used to generate an approximate pressure value based on the hypsometric formula
Reference : http://hyperphysics.phy-astr.gsu.edu/hbase/kinetic/barfor.html
Reference : http://keisan.casio.com/exec/system/1224585971
Reference : http://www.regentsprep.org/regents/math/algtrig/atp8b/exponentialresource.htm

Based on the three parameters calculated , weather condition at the point is generated. If there is high humidity and low pressure , Weather condition is defined as RAINY. If the temperature is below a certain limit and rain conditions are met , the weather condition is defined as SNOWY. All other cases are defined as SUNNY. 



Approach 2 Simulation Approach
==================================================

Historic data for Temperature , humidity and pressure is avaliable in gridded format marked by latitude and longitude. 
This historic data can be used to create a regression model with topographic and geographic parameters as input.
Multivariate regression or neural network based regression can be used create such a model.
Steps Involved

1) Download the gridded temperature , humidity and pressure data.
2) Get the geographic and topographic features of the latitude and longitude ,
3) Run a regression (neural net might be the better option considering all these parameters have non linear relationship) with these parameters (Distance to ocean , Distance to equator etc) as independent variables and temperature, pressure , humidity etc as dependent variables.  
4) Use the model generated to  get an approximate dependent variable values and add the time component to it. An ambitious approach would be to add the time series component to regression itself. But this will lead to all lot of time spending in tuning the regression (if it is neural net).


Approach 3 Brute Force
===================================================

Download 15 minute wise historic data for each of these parameters for the required area and store it time and latitude wise.
TO generate temperature , search the lat , long and elevation and add a small random component to it. This will be as realistic as it can get.
But the model will be very data heavy .

Approach 4 Statistical Weather Generation Algorithms
=====================================================
Well known algorithms like Richardson's markov chain based rain data  and related parameter generation
http://www.goldsim.com/Downloads/Library/Models/Applications/Hydrology/WGEN.pdf

This approach also needs some statistical variables about the past historic data. The paper also provides us with the required variables for more than one continent.

 Simulation approach will lead to a black box model , which does not give any control over the generated variable.  Brute force approach seemed too data heavy for a small application.  Statistical generation algorithms does not consider the topography and geography features. For the concern of time , fun of creating a toy environment and considering the control over the generated data , naive approach (Approach 1) is used in generating the weather data here.






 