Four attributes needs to be generated - 
1)Condition - specified by sun,rain and snow
2)Temperature - A double value
3)Pressure - A double value
4)Humidity - An integer value

Approach 1 - Naive Approach
==================================================

Time, latitude , longitude and elevation of the weather station are the inputs.

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
3)Location/Rotation (Because of the location , temperature changes , there by changing pressure) - Pressure belts
Equatorial Low Pressure Belt (Doldrums)
Sub-tropical High Pressure Belt
Sub-polar Low Pressure Belt
Polar High Pressure Belt 

Factors affecting humidity

1)Temperature
2)Closeness to water bodies
3)In coastal regions , sea breeze brings moisture with them and land breeze takes them away. Sea breeze - Day , Land breeze night

From past data gradients of all these factors can be deduced and used to create realistic weather estimates,

Approach 2 Simulation Approach
===============================================================

Historic data for Temperature , humidity and pressure is avaliable in gridded format marked by latitude and longitude. 
This historic data can be used to create a regression model with topographic and geographic parameters as input.
Multivariate regression or neural network based regression can be used create such a model.
ALl the dependent variables being 




 