package com.aspose.cloud.cells;

public class Line
    {
        public Line()
        { 
        
        }

        private LinkResponse link ;
        private boolean isAuto ;
        private boolean isVisible ;
        private boolean isAutomaticColor ;
        private Color color ;
        private double transparency ;
        private LineType style ;
        private WeightType weightType ;
        private double weightPt ;
        
        public LinkResponse getLink(){return link;}
        public boolean getIsAuto(){return isAuto;}
        public boolean getIsVisible(){return isVisible;}
        public boolean getisAutomaticColor(){return isAutomaticColor;}
        public Color getColor(){return color;}
        public double getTransparency(){return transparency;}
        public LineType getStyle(){return style;}
        public WeightType getWeightType(){return weightType;}
        public double getWeightPt(){return weightPt;}

    }