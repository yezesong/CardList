package com.sunsmart.cardlist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daogenerator.CardItem;

/**
 * Created by yzs on 2016/10/20.
 */

public final class FinalTest {
    public static final String[] TEST_ICON = new String[]{
            "http://pic34.nipic.com/20131028/2455348_171218804000_2.jpg",
            "http://t3.s2.dpfile.com/pc/mc/cae2b89a86b64fa36131a28fed5ac071%28450x280%29/thumb.jpg",
            "http://pic69.nipic.com/file/20150610/21067407_235512740000_2.jpg",
            "http://pic28.huitu.com/res/20150313/604562_20150313220208844364_1.jpg",
            "http://pic28.huitu.com/res/20150313/604562_20150313221148494321_1.jpg",
            "http://pic40.nipic.com/20140413/18457644_181441617107_2.jpg",
            "http://photoshow.108sq.com/user/2016/1008/12190756250003555431136644.jpg",
            "http://img.taopic.com/uploads/allimg/121209/234928-12120Z0543764.jpg",
            "http://www.wallcoo.com/animal/v195_Lively_Dogs/wallpapers/1280x800/Lively_Dogs_wallpaper_MIX88041_wallcoo.com.jpg",
            "http://pic13.nipic.com/20110325/2457331_082544259000_2.jpg",
            "http://img10.360buyimg.com/imgzone/g13/M02/02/0C/rBEhVFM9IygIAAAAAAJXsJP3Z2sAALLgAM5cGQAAlfI313.jpg",
            "http://www.51pinwei.com/uploads/allimg/140814/1331-140Q41P1392b.jpg"
    };

    public static final String[] TEST_NAME = new String[]{
            "蝴蝶为谁开",
            "打开灯光照照暖",
            "斑点水玛线,我只跟自己比,听世界的喧闹,你是我的眼",
            "情歌谱成一曲思念,打开灯光照照暖",
            "我只跟自己比,听世界的喧闹,你是我的眼,听世界的喧闹",
            "听世界的喧闹,即使我在乎,我只跟自己比,听世界的喧闹",
            "即使我在乎,我只跟自己比,听世界的喧闹,你是我的眼",
            "孤独的路灯,黛文 Make-up,黛文 Make-up, 你是我的眼",
            "黛文 Make-up, 你是我的眼",
            "曾经迩的味道",
            "谁伴我闯荡,你是我的眼,蝴蝶为谁开",
            "你是我的眼"
    };

    public static final String[] TEST_ADD = new String[]{
            "http://news.dahe.cn/2016/10-20/107636225.html",
            "http://digi.it.sohu.com/20161020/n470744067.shtml",
            "http://finance.sina.com.cn/zl/china/2016-10-20/zl-ifxwztrs9826824.shtml",
            "http://fashion.sohu.com/20160317/n440836936.shtml",
            "http://www.fawan.com/fwsgpc/2016/10/20/374449.html",
            "http://news.china.com/international/1000/20161020/23793040.html",
            "http://mt.sohu.com/20160924/n469102849.shtml",
            "http://yule.sohu.com/20161020/n470729018.shtml",
            "http://news.sohu.com/20161019/n470692567.shtml",
            "http://news.ifeng.com/a/20161020/50129413_0.shtml",
            "http://mt.sohu.com/20160928/n469343131.shtml",
            "http://mt.sohu.com/20160903/n467543176.shtml"
    };

    public static List<CardItem> getTestItem(int size) {
        List<CardItem> cardList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int random = (int) (Math.random() * (11 + 1));
            long id = (long) (Math.random() * 1000 + 10000);
            CardItem item = new CardItem(id, TEST_ICON[random], TEST_ADD[random], TEST_NAME[random], new Date());
            cardList.add(item);
        }
        return cardList;
    }
}
