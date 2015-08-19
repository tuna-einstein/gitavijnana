package com.usp.gitavijnana.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gargoylesoftware.htmlunit.javascript.host.NodeList;
import com.google.api.server.spi.Strings;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.IFrameElement;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.usp.gitavijnana.client.service.AddSloka;
import com.usp.gitavijnana.client.service.AddSlokaAsync;
import com.usp.gitavijnana.shared.model.Sloka;

public class Main implements EntryPoint {

    private TextArea audioLink;
    private TextBox chapter = new TextBox();
    private TextBox slokaNum = new TextBox();

    public void onModuleLoad() {

        //        ScriptInjector.fromUrl("http://example.com/foo.js").setCallback(
        //            new Callback() {
        //                @Override
        //               public void onFailure(Exception reason) {
        //                 Window.alert("Script load failed.");
        //               }
        //               public void onSuccess(Void result) {
        //                 Window.alert("Script load success.");
        //               }
        //            }).inject();


        String width = "1200px";

        VerticalPanel panel = new VerticalPanel();



        String chapterOld = Cookies.getCookie("chapter");
        String slokaNumOld = Cookies.getCookie("slokaNum");

        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(new Label("Chapter : "));
        hPanel.add(chapter);
        chapter.setText(chapterOld);

        hPanel.add(new Label("Sloka num : "));
        hPanel.add(slokaNum);
        slokaNum.setText(slokaNumOld);

        slokaNum.addValueChangeHandler(new ValueChangeHandler<String>() {

            @Override
            public void onValueChange(ValueChangeEvent<String> event) {
                setAudioLink();
                fooRunner(Integer.valueOf(chapter.getText()), Integer.valueOf(slokaNum.getText()));

            }
        });


        Label sanskritLabel = new Label("In sanskrit");
        final TextArea sanskrit = new TextArea();
        sanskrit.setWidth(width);
        sanskrit.setHeight("50px");
        sanskrit.getElement().setId("sanskrit_id");


        Label englishLabel = new Label("In English");
        final TextArea english = new TextArea();
        english.getElement().setId("english_id");
        english.setWidth(width);
        english.setHeight("50px");


        Label englishTranslationLabel = new Label("English Translation");
        final TextArea englishTranslation = new TextArea();
        englishTranslation.setWidth(width);
        englishTranslation.setHeight("50px");
        englishTranslation.getElement().setId("english_translation_id");

        Label sanskritToEnglishLabel = new Label("Sanskrit To English");
        final TextArea sanskritToEnglish = new TextArea();
        sanskritToEnglish.setWidth(width);
        sanskritToEnglish.setHeight("50px");
        sanskritToEnglish.getElement().setId("sanskrit_to_english_id");

        Label audioLinkLabel = new Label("Audio Link");
        audioLink = new TextArea();
        audioLink.setWidth(width);
        audioLink.setHeight("50px");

        final Button button = new Button(" Submit" );
        button.setWidth("400px");
        button.setHeight("100px");



        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                AddSlokaAsync async = GWT.create(AddSloka.class);
                button.setText("Please wait...");


                Sloka sloka = new Sloka();
                sloka.setChapter(Integer.valueOf(chapter.getText()));
                sloka.setSlokaNum(Integer.valueOf(slokaNum.getText()));
                sloka.setAudioLink(audioLink.getText());
                sloka.setEnglish(english.getText());
                sloka.setSanskrit(sanskrit.getText());
                sloka.setSanskritToEnglish(sanskritToEnglish.getText());
                sloka.setEnglishTranslation(englishTranslation.getText());


                async.addSloka(sloka, new AsyncCallback<Void>() {

                    @Override
                    public void onSuccess(Void result) {
                        
                        Cookies.setCookie("chapter", chapter.getText());
                        Cookies.setCookie("slokaNum", slokaNum.getText());
                        
                        
                        Window.Location.reload();
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert(caught.toString());

                    }
                });   
            }
        });







        panel.add(hPanel);
        panel.add(sanskritLabel);
        panel.add(sanskrit);

        panel.add(englishLabel);
        panel.add(english);

        panel.add(englishTranslationLabel);
        panel.add(englishTranslation);

        panel.add(sanskritToEnglishLabel);
        panel.add(sanskritToEnglish);

        panel.add(audioLinkLabel);
        panel.add(audioLink);

        panel.add(button);

        RootPanel.get("main_content").add(panel);

    }


    public static native void fooRunner(int chapter, int slokaNum) /*-{

    $wnd.$("#dynamic_js").load("dynamicjsloader.html", function(){

     $wnd.umasankar1(chapter, slokaNum);
    $wnd.umasankar(chapter, slokaNum);
    });
  }-*/;


    private void setAudioLink() {
        if ("".equals(audioLink.getText())) {
            String chp =chapter.getText();
            if (chp.length() == 1) {
                chp = "0" + chp;
            }
            String slk = slokaNum.getText();
            if (slk.length() == 1) {
                slk = "0" + slk;
            }
            audioLink.setText("http://www.geetachanting.net/bvg/audio/x0001/"+chp+"/bvg" + chp +"v"+ slk +".mp3");
        }
    }
}