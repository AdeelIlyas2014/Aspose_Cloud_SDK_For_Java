package com.aspose.cloud.cells;

public class FillFormat
    {
        public FillFormat()
        { 
        
        }

        private LinkResponse link ;
        private FillType type ;
        private SolidFill solidFill ;
        private PatternFill patternFill ;
        private TextureFill textureFill ;
        private GradientFill gradientFill ;
        
        public LinkResponse getlink(){return link;}
        public FillType getType(){return type;}
        public SolidFill getSolidFill(){return solidFill;}
        public PatternFill getPatternFill(){return patternFill;}
        public TextureFill getTextureFill(){return textureFill;}
        public GradientFill getGradientFill(){return gradientFill;}
       
    }