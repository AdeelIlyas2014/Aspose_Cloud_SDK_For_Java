package com.aspose.cloud.cells;

import java.util.List;

public class GradientFill
    {
        public GradientFill()
        { 
        
        }

        private GradientFillType fillType ;
        private GradientDirectionType directionType ;
        private int angle ;
        private List<GradientFillStop> gradientFillStops ;
        
        
        public GradientFillType getFillType(){return fillType;}
        public GradientDirectionType getDirectionType(){return directionType;}
        public int getAngle(){return angle;}
        public List<GradientFillStop> getGradientFillStops(){return gradientFillStops;}
        
    }