package com.aspose.cloud.words;
import java.util.List;

    public class DrawingObject
    {

        public DrawingObject() { }

        private LinkResponse link;
        public LinkResponse getlink(){return link;}
        public void setlink(LinkResponse link){this.link=link;}

        private float height;
        public float getHeight(){return height;}
        public void setHeight(float height){this.height=height;}

        private LinkResponse imageDataLink;
        public LinkResponse getImageDataLink(){return imageDataLink;}
        public void setImageDataLink(LinkResponse imageDataLink){this.imageDataLink=imageDataLink;}

        private LinkResponse oleDataLink;
        public LinkResponse getOleDataLink(){return oleDataLink;}
        public void setOleDataLink(LinkResponse oleDataLink){this.oleDataLink=oleDataLink;}

        private List<LinkResponse> renderLinks;
        public List<LinkResponse> getRenderLinks(){return renderLinks;}
        public void setRenderLinks(List<LinkResponse> renderLinks){this.renderLinks=renderLinks;}

        private float width;
        public float getWidth(){return width;}
        public void setWidth(float width){this.width=width;}


    }