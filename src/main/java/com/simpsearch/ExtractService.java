package com.simpsearch;

public class ExtractService {

    public String extract(String url, boolean noInlineRefs, boolean removeNumbers) {

        StringBuilder api = new StringBuilder(
                "https://www.w3.org/services/html2txt?url="
        );

        api.append(Utils.encodeQuery(url));

        if(noInlineRefs) {
            api.append("&noinlinerefs=on");
        }

        if(removeNumbers) {
            api.append("&nonums=on");
        }

        return Utils.callHtml2TxtApi(api.toString());
    }
}