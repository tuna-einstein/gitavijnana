package com.usp.gitavijnana.client;

import com.google.api.server.spi.Strings;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
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

    public void onModuleLoad() {
        VerticalPanel panel = new VerticalPanel();
        
        String width = "1200px";
        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.add(new Label("Chapter : "));
        final TextBox chapter = new TextBox();
        hPanel.add(chapter);
        
        hPanel.add(new Label("Sloka num : "));
        final TextBox slokaNum = new TextBox();
        hPanel.add(slokaNum);
        
        
        Label sanskritLabel = new Label("In sanskrit");
        final TextArea sanskrit = new TextArea();
        sanskrit.setWidth(width);
        sanskrit.setHeight("50px");
        
        
        Label englishLabel = new Label("In English");
        final TextArea english = new TextArea();
        english.setWidth(width);
        english.setHeight("50px");
        
        
        Label englishTranslationLabel = new Label("English Translation");
        final TextArea englishTranslation = new TextArea();
        englishTranslation.setWidth(width);
        englishTranslation.setHeight("50px");
        
        Label sanskritToEnglishLabel = new Label("Sanskrit To English");
        final TextArea sanskritToEnglish = new TextArea();
        sanskritToEnglish.setWidth(width);
        sanskritToEnglish.setHeight("50px");
        
        Label audioLinkLabel = new Label("Audio Link");
        final TextArea audioLink = new TextArea();
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
                        int newSloka = Integer.valueOf(slokaNum.getText()) + 1;
                        slokaNum.setText(newSloka + "");;
                        english.setText("");
                        sanskrit.setText("");
                        sanskritToEnglish.setText("");
                        englishTranslation.setText("");
                        audioLink.setText("");
                        button.setText(" Add ");
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
        
        RootPanel.get().add(panel);

    }
}