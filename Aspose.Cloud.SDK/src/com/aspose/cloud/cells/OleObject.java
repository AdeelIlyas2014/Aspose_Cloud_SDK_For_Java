package com.aspose.cloud.cells;
import java.lang.String;

public class OleObject
    {
        public OleObject()
        {

        }

        private String name;
        private String placement;
        private int upperLeftRow ;
        private int top;
        private int upperLeftColumn ;
        private int left;
        private int lowerRightRow ;
        private int bottom ;
        private int lowerRightColumn;
        private int right ;
        private int width ;
        private int height;
        private int x ;
        private int y;
        private boolean displayAsIcon ;
        private String fileType;
        private String imageSourceFullName ;
        private boolean isAutoSize;
        private boolean isLink ;
        private String progID ;
        private String sourceFullName;
        
        
        public String getName(){return name;}
        public String getPlacement(){return placement;}
        public int getUpperLeftRow(){return upperLeftRow;}
        public int getTop(){return top;}
        public int getUpperLeftColumn(){return upperLeftColumn;}
        public int getLeft(){return left;}
        public int LowerRightRow(){return lowerRightRow;}
        public int Bottom(){return bottom;}
        public int LowerRightColumn(){return lowerRightColumn;}
        public int Right(){return right;}
        public int Width(){return width;}
        public int Height(){return height;}
        public int X(){return x;}
        public int Y(){return y;}
        public boolean DisplayAsIcon(){return displayAsIcon;}
        public String FileType(){return fileType;}
        public String ImageSourceFullName(){return imageSourceFullName;}
        public boolean IsAutoSize(){return isAutoSize;}
        public boolean IsLink(){return isLink;}
        public String ProgID(){return progID;}
        public String SourceFullName(){return sourceFullName;}

    }