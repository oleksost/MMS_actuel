/******************************************************************************************************************
* File:Plumber.java
* Course: 17655
* Project: Assignment 1
* Copyright: Copyright (c) 2003 Carnegie Mellon University
* Versions:
*	1.0 November 2008 - Sample Pipe and Filter code (ajl).
*
* Description:
*
* This class serves as an example to illstrate how to use the PlumberTemplate to create a main thread that
* instantiates and connects a set of filters. This example consists of three filters: a source, a middle filter
* that acts as a pass-through filter (it does nothing to the data), and a sink filter which illustrates all kinds
* of useful things that you can do with the input stream of data.
*
* Parameters: 		None
*
* Internal Methods:	None
*
******************************************************************************************************************/
public class Plumber
{
   public static void main( String argv[]) 
   {
		/****************************************************************************
		* Here we instantiate three filters.
		****************************************************************************/

	   
	   
	   
	   
		SourceFilter Filter1 = new SourceFilter();
		SourceFilter Filter1_a = new SourceFilter();
		MiddleFilter_altitude_convertion Filter2 = new MiddleFilter_altitude_convertion();
		MiddleFilter_altitude_convertion Filter2_a = new MiddleFilter_altitude_convertion();
		MiddleFilter_tempreture_convertion Filter3 = new MiddleFilter_tempreture_convertion();
		MiddleFilter_tempreture_convertion Filter3_a = new MiddleFilter_tempreture_convertion();
		//SinkFilter Filter3 = new SinkFilter();
		//SystemB_SinkFilter Filter3 = new SystemB_SinkFilter();
		Filter_correct Filter4 = new Filter_correct();
		Filter_outlier Filter5 = new Filter_outlier();
		//SinkFilter Filter3 = new SinkFilter();
		SinkFilter_outlier Filter6 = new SinkFilter_outlier();
		SinkFilter_correct Filter7 = new SinkFilter_correct();

		
		
		
		
		/****************************************************************************
		* Here we connect the filters starting with the sink filter (Filter 1) which
		* we connect to Filter2 the middle filter. Then we connect Filter2 to the
		* source filter (Filter3).
		****************************************************************************/

		Filter7.Connect(Filter4);
		Filter6.Connect(Filter5);
		Filter4.Connect(Filter3_a);
		Filter5.Connect(Filter3);
		Filter3.Connect(Filter2);
		Filter3_a.Connect(Filter2_a);
		Filter2.Connect(Filter1);
		Filter2_a.Connect(Filter1_a);
		
		
		/****************************************************************************
		* Here we start the filters up. All-in-all,... its really kind of boring.
		****************************************************************************/

		Filter1_a.start();
		Filter2_a.start();
		Filter3_a.start();
		Filter4.start();
		Filter7.start();
		
		Filter1.start();
		Filter2.start();
		Filter3.start();
		Filter5.start();
		Filter6.start();
		
		

   } // main

} // Plumber