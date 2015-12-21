package com.naroran.onsport.mytests;


import android.test.InstrumentationTestCase;
import com.naroran.onsport.data.PostItem;
import com.naroran.onsport.util.Json;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ServerAnswerTest extends InstrumentationTestCase {

    private boolean validData = false;
    private boolean validParse = false;
    private JSONObject jsonObj;
    @Override
    protected  void setUp() throws Exception{
        super.setUp();
    }

    @Test
    public void  testServerNews(){
        setData();
        setParse();
        verifyException();
    }

    @Test
    public void setData(){
        String data = "{\"news\":[{\"url\":\"http:\\/\\/football.ua\\/spain\\/290628-k-navas-vse-igroki-na-storone-trenera.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290628.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 22:29\",\"title\":\"\\u041a. \\u041d\\u0430\\u0432\\u0430\\u0441: &quot;\\u0412\\u0441\\u0435 \\u0438\\u0433\\u0440\\u043e\\u043a\\u0438 \\u043d\\u0430 \\u0441\\u0442\\u043e\\u0440\\u043e\\u043d\\u0435 \\u0442\\u0440\\u0435\\u043d\\u0435\\u0440\\u0430&quot;\",\"description\":\"\\u0412\\u0440\\u0430\\u0442\\u0430\\u0440\\u044c \\u043c\\u0430\\u0434\\u0440\\u0438\\u0434\\u0441\\u043a\\u043e\\u0433\\u043e \\u0420\\u0435\\u0430\\u043b\\u0430 \\u0438 \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u041a\\u043e\\u0441\\u0442\\u0430-\\u0420\\u0438\\u043a\\u0438 \\u041a\\u0435\\u0439\\u043b\\u043e\\u0440 \\u041d\\u0430\\u0432\\u0430\\u0441 \\u043f\\u043e\\u0434\\u0435\\u043b\\u0438\\u043b\\u0441\\u044f \\u0441\\u0432\\u043e\\u0438\\u043c\\u0438 \\u0432\\u043f\\u0435\\u0447\\u0430\\u0442\\u043b\\u0435\\u043d\\u0438\\u044f\\u043c\\u0438 \\u043e\\u0442 \\u0434\\u043e\\u043c\\u0430\\u0448\\u043d\\u0435\\u0433\\u043e \\u043c\\u0430\\u0442\\u0447\\u0430 \\u041f\\u0440\\u0438\\u043c\\u0435\\u0440\\u044b \\u043f\\u0440\\u043e\\u0442\\u0438\\u0432 \\u0420\\u0430\\u0439\\u043e \\u0412\\u0430\\u043b\\u044c\\u0435\\u043a\\u0430\\u043d\\u043e (10:2).\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/euro2016\\/290627-futbolnaja-associacija-uehlsa-khochet-prodlit-koulmehna.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290627.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 22:07\",\"title\":\"\\u0424\\u0443\\u0442\\u0431\\u043e\\u043b\\u044c\\u043d\\u0430\\u044f \\u0430\\u0441\\u0441\\u043e\\u0446\\u0438\\u0430\\u0446\\u0438\\u044f \\u0423\\u044d\\u043b\\u044c\\u0441\\u0430 \\u0445\\u043e\\u0447\\u0435\\u0442 \\u043f\\u0440\\u043e\\u0434\\u043b\\u0438\\u0442\\u044c \\u041a\\u043e\\u0443\\u043b\\u043c\\u044d\\u043d\\u0430\",\"description\":\"\\u0418\\u0441\\u043f\\u043e\\u043b\\u043d\\u0438\\u0442\\u0435\\u043b\\u044c\\u043d\\u044b\\u0439 \\u0434\\u0438\\u0440\\u0435\\u043a\\u0442\\u043e\\u0440 \\u0432\\u0430\\u043b\\u043b\\u0438\\u0439\\u0441\\u043a\\u043e\\u0439 \\u0444\\u0443\\u0442\\u0431\\u043e\\u043b\\u044c\\u043d\\u043e\\u0439 \\u0444\\u0435\\u0434\\u0435\\u0440\\u0430\\u0446\\u0438\\u0438 \\u0414\\u0436\\u043e\\u043d\\u0430\\u0442\\u0430\\u043d \\u0424\\u043e\\u0440\\u0434 \\u043e\\u0442\\u043c\\u0435\\u0442\\u0438\\u043b, \\u0447\\u0442\\u043e \\u043f\\u043e\\u0441\\u043b\\u0435 \\u041d\\u043e\\u0432\\u043e\\u0433\\u043e \\u0433\\u043e\\u0434\\u0430 \\u0430\\u0441\\u0441\\u043e\\u0446\\u0438\\u0430\\u0446\\u0438\\u044f \\u043d\\u0430\\u043c\\u0435\\u0440\\u0435\\u043d\\u0430 \\u043f\\u0435\\u0440\\u0435\\u0437\\u0430\\u043a\\u043b\\u044e\\u0447\\u0438\\u0442\\u044c \\u043a\\u043e\\u043d\\u0442\\u0440\\u0430\\u043a\\u0442 \\u0441 \\u043d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a\\u043e\\u043c \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u041a\\u0440\\u0438\\u0441\\u043e\\u043c \\u041a\\u043e\\u0443\\u043b\\u043c\\u044d\\u043d\\u043e\\u043c.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/italy\\/290626-iguain-nadeemsja-vyigrat-skudetto.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290626.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 21:31\",\"title\":\"\\u0418\\u0433\\u0443\\u0430\\u0438\\u043d: \\u043d\\u0430\\u0434\\u0435\\u0435\\u043c\\u0441\\u044f \\u0432\\u044b\\u0438\\u0433\\u0440\\u0430\\u0442\\u044c \\u0441\\u043a\\u0443\\u0434\\u0435\\u0442\\u0442\\u043e\",\"description\":\"\\u041d\\u0430\\u043f\\u0430\\u0434\\u0430\\u044e\\u0449\\u0438\\u0439 \\u041d\\u0430\\u043f\\u043e\\u043b\\u0438 \\u0438 \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u0410\\u0440\\u0433\\u0435\\u043d\\u0442\\u0438\\u043d\\u044b \\u0413\\u043e\\u043d\\u0441\\u0430\\u043b\\u043e \\u0418\\u0433\\u0443\\u0430\\u0438\\u043d \\u043f\\u043e\\u0434\\u0435\\u043b\\u0438\\u043b\\u0441\\u044f \\u0441\\u0432\\u043e\\u0438\\u043c\\u0438 \\u044d\\u043c\\u043e\\u0446\\u0438\\u044f\\u043c\\u0438 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u0432\\u044b\\u0435\\u0437\\u0434\\u043d\\u043e\\u0439 \\u043f\\u043e\\u0431\\u0435\\u0434\\u044b \\u043d\\u0430\\u0434 \\u0410\\u0442\\u0430\\u043b\\u0430\\u043d\\u0442\\u043e\\u0439 (3:1).\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/spain\\/290624-primera-gostevye-pobedy-viljarreala-i-selty-atletik-silnee-levante.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290624.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 21:07\",\"title\":\"\\u041f\\u0440\\u0438\\u043c\\u0435\\u0440\\u0430. \\u0413\\u043e\\u0441\\u0442\\u0435\\u0432\\u044b\\u0435 \\u043f\\u043e\\u0431\\u0435\\u0434\\u044b \\u0412\\u0438\\u043b\\u044c\\u044f\\u0440\\u0440\\u0435\\u0430\\u043b\\u0430 \\u0438 \\u0421\\u0435\\u043b\\u044c\\u0442\\u044b, \\u0410\\u0442\\u043b\\u0435\\u0442\\u0438\\u043a \\u0441\\u0438\\u043b\\u044c\\u043d\\u0435\\u0435 \\u041b\\u0435\\u0432\\u0430\\u043d\\u0442\\u0435\",\"description\":\"\\u0412\\u0438\\u043b\\u044c\\u044f\\u0440\\u0440\\u0435\\u0430\\u043b \\u0441\\u043c\\u043e\\u0433 \\u0432 \\u0433\\u043e\\u0441\\u0442\\u044f\\u0445 \\u043e\\u0434\\u043e\\u043b\\u0435\\u0442\\u044c \\u0420\\u0435\\u0430\\u043b \\u0421\\u043e\\u0441\\u044c\\u0435\\u0434\\u0430\\u0434, \\u0421\\u0435\\u043b\\u044c\\u0442\\u0430 \\u0431\\u0435\\u0437 \\u041d\\u043e\\u043b\\u0438\\u0442\\u043e \\u043f\\u0435\\u0440\\u0435\\u0438\\u0433\\u0440\\u0430\\u043b\\u0430 \\u0413\\u0440\\u0430\\u043d\\u0430\\u0434\\u0443, \\u0430 \\u041b\\u044c\\u0432\\u044b \\u0434\\u043e\\u0436\\u0430\\u043b\\u0438 \\u041b\\u0435\\u0432\\u0430\\u043d\\u0442\\u0435.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/england\\/290623-marez-ne-pokinu-lester.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290623.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:53\",\"title\":\"\\u041c\\u0430\\u0440\\u0435\\u0437: &quot;\\u041d\\u0435 \\u043f\\u043e\\u043a\\u0438\\u043d\\u0443 \\u041b\\u0435\\u0441\\u0442\\u0435\\u0440&quot;\",\"description\":\"\\u041f\\u043e\\u043b\\u0443\\u0437\\u0430\\u0449\\u0438\\u0442\\u043d\\u0438\\u043a \\u041b\\u0435\\u0441\\u0442\\u0435\\u0440 \\u0421\\u0438\\u0442\\u0438 \\u0438 \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u0410\\u043b\\u0436\\u0438\\u0440\\u0430 \\u0420\\u0438\\u044f\\u0434 \\u041c\\u0430\\u0440\\u0435\\u0437 \\u043f\\u043e\\u0434\\u0447\\u0435\\u0440\\u043a\\u043d\\u0443\\u043b, \\u0447\\u0442\\u043e \\u043d\\u0435 \\u0437\\u0430\\u0438\\u043d\\u0442\\u0435\\u0440\\u0435\\u0441\\u043e\\u0432\\u0430\\u043d \\u0432 \\u043f\\u0435\\u0440\\u0435\\u0445\\u043e\\u0434\\u0435 \\u0432 \\u0434\\u0440\\u0443\\u0433\\u0443\\u044e \\u043a\\u043e\\u043c\\u0430\\u043d\\u0434\\u0443.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/spain\\/290622-trener-rajjo-v-ehtom-matche-net-pobeditelejj.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290622.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:45\",\"title\":\"\\u0422\\u0440\\u0435\\u043d\\u0435\\u0440 \\u0420\\u0430\\u0439\\u043e: &quot;\\u0412 \\u044d\\u0442\\u043e\\u043c \\u043c\\u0430\\u0442\\u0447\\u0435 \\u043d\\u0435\\u0442 \\u043f\\u043e\\u0431\\u0435\\u0434\\u0438\\u0442\\u0435\\u043b\\u0435\\u0439&quot;\",\"description\":\"\\u041d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a \\u0420\\u0430\\u0439\\u043e \\u0412\\u0430\\u043b\\u044c\\u0435\\u043a\\u0430\\u043d\\u043e \\u041f\\u0430\\u043a\\u043e \\u0425\\u0435\\u043c\\u0435\\u0441 \\u043f\\u043e\\u043e\\u0431\\u0449\\u0430\\u043b\\u0441\\u044f \\u0441 \\u0436\\u0443\\u0440\\u043d\\u0430\\u043b\\u0438\\u0441\\u0442\\u0430\\u043c\\u0438 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u043c\\u0430\\u0442\\u0447\\u0430 \\u043f\\u0440\\u043e\\u0442\\u0438\\u0432 \\u0420\\u0435\\u0430\\u043b\\u0430.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/spain\\/290621-benites-ne-sobirajus-obsuzhdat-reshenija-sudi.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290621.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:31\",\"title\":\"\\u0411\\u0435\\u043d\\u0438\\u0442\\u0435\\u0441: &quot;\\u041d\\u0435 \\u0441\\u043e\\u0431\\u0438\\u0440\\u0430\\u044e\\u0441\\u044c \\u043e\\u0431\\u0441\\u0443\\u0436\\u0434\\u0430\\u0442\\u044c \\u0440\\u0435\\u0448\\u0435\\u043d\\u0438\\u044f \\u0441\\u0443\\u0434\\u044c\\u0438&quot;\",\"description\":\"\\u041d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a \\u0420\\u0435\\u0430\\u043b\\u0430 \\u0420\\u0430\\u0444\\u0430\\u044d\\u043b\\u044c \\u0411\\u0435\\u043d\\u0438\\u0442\\u0435\\u0441 \\u043e\\u0442\\u0432\\u0435\\u0442\\u0438\\u043b \\u043d\\u0430 \\u0432\\u043e\\u043f\\u0440\\u043e\\u0441\\u044b \\u0436\\u0443\\u0440\\u043d\\u0430\\u043b\\u0438\\u0441\\u0442\\u043e\\u0432 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u043c\\u0430\\u0442\\u0447\\u0430 \\u043f\\u0440\\u043e\\u0442\\u0438\\u0432 \\u0420\\u0430\\u0439\\u043e \\u0412\\u0430\\u043b\\u044c\\u0435\\u043a\\u0430\\u043d\\u043e.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/germany\\/290619-bundesliga-borussija-m-v-menshinstve-dozhimaet-darmshtadt.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290619.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:28\",\"title\":\"\\u0411\\u0443\\u043d\\u0434\\u0435\\u0441\\u043b\\u0438\\u0433\\u0430. \\u0411\\u043e\\u0440\\u0443\\u0441\\u0441\\u0438\\u044f \\u041c \\u0432 \\u043c\\u0435\\u043d\\u044c\\u0448\\u0438\\u043d\\u0441\\u0442\\u0432\\u0435 \\u0434\\u043e\\u0436\\u0438\\u043c\\u0430\\u0435\\u0442 \\u0414\\u0430\\u0440\\u043c\\u0448\\u0442\\u0430\\u0434\\u0442\",\"description\":\"\\u0423\\u0441\\u0442\\u0443\\u043f\\u0430\\u044f \\u0432 \\u0441\\u0447\\u0435\\u0442 \\u0438 \\u0438\\u0433\\u0440\\u0430\\u044f \\u0432 \\u043c\\u0435\\u043d\\u044c\\u0448\\u0438\\u043d\\u0441\\u0442\\u0432\\u0435, \\u041c\\u0435\\u043d\\u0445\\u0435\\u043d\\u0433\\u043b\\u0430\\u0434\\u0431\\u0430\\u0445\\u0443 \\u0443\\u0434\\u0430\\u043b\\u043e\\u0441\\u044c \\u043e\\u0434\\u0435\\u0440\\u0436\\u0430\\u0442\\u044c \\u043f\\u043e\\u0431\\u0435\\u0434\\u0443 \\u043d\\u0430\\u0434 \\u0414\\u0430\\u0440\\u043c\\u0448\\u0442\\u0430\\u0434\\u0442\\u043e\\u043c. \",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/france\\/290620-pszh-stal-rekordsmenom-ligi-1.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290620.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:24\",\"title\":\"\\u041f\\u0421\\u0416 \\u0441\\u0442\\u0430\\u043b \\u0440\\u0435\\u043a\\u043e\\u0440\\u0434\\u0441\\u043c\\u0435\\u043d\\u043e\\u043c \\u041b\\u0438\\u0433\\u0438 1\",\"description\":\"\\u041a\\u0440\\u0443\\u043f\\u043d\\u043e \\u043f\\u043e\\u0431\\u0435\\u0434\\u0438\\u0432 \\u0432 \\u0433\\u043e\\u0441\\u0442\\u044f\\u0445 \\u041a\\u0430\\u043d (3:0), \\u043f\\u043e\\u0434\\u043e\\u043f\\u0435\\u0447\\u043d\\u044b\\u0435 \\u041b\\u043e\\u0440\\u0430\\u043d\\u0430 \\u0411\\u043b\\u0430\\u043d\\u0430 \\u0437\\u0430\\u0432\\u0435\\u0440\\u0448\\u0438\\u043b\\u0438 \\u043f\\u0435\\u0440\\u0432\\u044b\\u0439 \\u043a\\u0440\\u0443\\u0433 \\u0442\\u0435\\u043a\\u0443\\u0449\\u0435\\u0433\\u043e \\u0447\\u0435\\u043c\\u043f\\u0438\\u043e\\u043d\\u0430\\u0442\\u0430 \\u0424\\u0440\\u0430\\u043d\\u0446\\u0438\\u0438 \\u0441 \\u0440\\u0435\\u043a\\u043e\\u0440\\u0434\\u043d\\u044b\\u043c 51 \\u043e\\u0447\\u043a\\u043e\\u043c \\u0432 \\u0430\\u043a\\u0442\\u0438\\u0432\\u0435.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/england\\/290618-klopp-prinjali-mnogo-nepravilnykh-reshenijj.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290618.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:08\",\"title\":\"\\u041a\\u043b\\u043e\\u043f\\u043f: &quot;\\u041f\\u0440\\u0438\\u043d\\u044f\\u043b\\u0438 \\u043c\\u043d\\u043e\\u0433\\u043e \\u043d\\u0435\\u043f\\u0440\\u0430\\u0432\\u0438\\u043b\\u044c\\u043d\\u044b\\u0445 \\u0440\\u0435\\u0448\\u0435\\u043d\\u0438\\u0439&quot;\",\"description\":\"\\u041d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a \\u041b\\u0438\\u0432\\u0435\\u0440\\u043f\\u0443\\u043b\\u044f \\u042e\\u0440\\u0433\\u0435\\u043d \\u041a\\u043b\\u043e\\u043f\\u043f \\u043e\\u0442\\u0432\\u0435\\u0442\\u0438\\u043b \\u043d\\u0430 \\u0432\\u043e\\u043f\\u0440\\u043e\\u0441\\u044b \\u0436\\u0443\\u0440\\u043d\\u0430\\u043b\\u0438\\u0441\\u0442\\u043e\\u0432 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u043f\\u043e\\u0440\\u0430\\u0436\\u0435\\u043d\\u0438\\u044f \\u043e\\u0442 \\u0423\\u043e\\u0442\\u0444\\u043e\\u0440\\u0434\\u0430.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"}]}{\"news\":[{\"url\":\"http:\\/\\/football.ua\\/spain\\/290628-k-navas-vse-igroki-na-storone-trenera.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290628.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 22:29\",\"title\":\"\\u041a. \\u041d\\u0430\\u0432\\u0430\\u0441: &quot;\\u0412\\u0441\\u0435 \\u0438\\u0433\\u0440\\u043e\\u043a\\u0438 \\u043d\\u0430 \\u0441\\u0442\\u043e\\u0440\\u043e\\u043d\\u0435 \\u0442\\u0440\\u0435\\u043d\\u0435\\u0440\\u0430&quot;\",\"description\":\"\\u0412\\u0440\\u0430\\u0442\\u0430\\u0440\\u044c \\u043c\\u0430\\u0434\\u0440\\u0438\\u0434\\u0441\\u043a\\u043e\\u0433\\u043e \\u0420\\u0435\\u0430\\u043b\\u0430 \\u0438 \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u041a\\u043e\\u0441\\u0442\\u0430-\\u0420\\u0438\\u043a\\u0438 \\u041a\\u0435\\u0439\\u043b\\u043e\\u0440 \\u041d\\u0430\\u0432\\u0430\\u0441 \\u043f\\u043e\\u0434\\u0435\\u043b\\u0438\\u043b\\u0441\\u044f \\u0441\\u0432\\u043e\\u0438\\u043c\\u0438 \\u0432\\u043f\\u0435\\u0447\\u0430\\u0442\\u043b\\u0435\\u043d\\u0438\\u044f\\u043c\\u0438 \\u043e\\u0442 \\u0434\\u043e\\u043c\\u0430\\u0448\\u043d\\u0435\\u0433\\u043e \\u043c\\u0430\\u0442\\u0447\\u0430 \\u041f\\u0440\\u0438\\u043c\\u0435\\u0440\\u044b \\u043f\\u0440\\u043e\\u0442\\u0438\\u0432 \\u0420\\u0430\\u0439\\u043e \\u0412\\u0430\\u043b\\u044c\\u0435\\u043a\\u0430\\u043d\\u043e (10:2).\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/euro2016\\/290627-futbolnaja-associacija-uehlsa-khochet-prodlit-koulmehna.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290627.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 22:07\",\"title\":\"\\u0424\\u0443\\u0442\\u0431\\u043e\\u043b\\u044c\\u043d\\u0430\\u044f \\u0430\\u0441\\u0441\\u043e\\u0446\\u0438\\u0430\\u0446\\u0438\\u044f \\u0423\\u044d\\u043b\\u044c\\u0441\\u0430 \\u0445\\u043e\\u0447\\u0435\\u0442 \\u043f\\u0440\\u043e\\u0434\\u043b\\u0438\\u0442\\u044c \\u041a\\u043e\\u0443\\u043b\\u043c\\u044d\\u043d\\u0430\",\"description\":\"\\u0418\\u0441\\u043f\\u043e\\u043b\\u043d\\u0438\\u0442\\u0435\\u043b\\u044c\\u043d\\u044b\\u0439 \\u0434\\u0438\\u0440\\u0435\\u043a\\u0442\\u043e\\u0440 \\u0432\\u0430\\u043b\\u043b\\u0438\\u0439\\u0441\\u043a\\u043e\\u0439 \\u0444\\u0443\\u0442\\u0431\\u043e\\u043b\\u044c\\u043d\\u043e\\u0439 \\u0444\\u0435\\u0434\\u0435\\u0440\\u0430\\u0446\\u0438\\u0438 \\u0414\\u0436\\u043e\\u043d\\u0430\\u0442\\u0430\\u043d \\u0424\\u043e\\u0440\\u0434 \\u043e\\u0442\\u043c\\u0435\\u0442\\u0438\\u043b, \\u0447\\u0442\\u043e \\u043f\\u043e\\u0441\\u043b\\u0435 \\u041d\\u043e\\u0432\\u043e\\u0433\\u043e \\u0433\\u043e\\u0434\\u0430 \\u0430\\u0441\\u0441\\u043e\\u0446\\u0438\\u0430\\u0446\\u0438\\u044f \\u043d\\u0430\\u043c\\u0435\\u0440\\u0435\\u043d\\u0430 \\u043f\\u0435\\u0440\\u0435\\u0437\\u0430\\u043a\\u043b\\u044e\\u0447\\u0438\\u0442\\u044c \\u043a\\u043e\\u043d\\u0442\\u0440\\u0430\\u043a\\u0442 \\u0441 \\u043d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a\\u043e\\u043c \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u041a\\u0440\\u0438\\u0441\\u043e\\u043c \\u041a\\u043e\\u0443\\u043b\\u043c\\u044d\\u043d\\u043e\\u043c.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/italy\\/290626-iguain-nadeemsja-vyigrat-skudetto.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290626.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 21:31\",\"title\":\"\\u0418\\u0433\\u0443\\u0430\\u0438\\u043d: \\u043d\\u0430\\u0434\\u0435\\u0435\\u043c\\u0441\\u044f \\u0432\\u044b\\u0438\\u0433\\u0440\\u0430\\u0442\\u044c \\u0441\\u043a\\u0443\\u0434\\u0435\\u0442\\u0442\\u043e\",\"description\":\"\\u041d\\u0430\\u043f\\u0430\\u0434\\u0430\\u044e\\u0449\\u0438\\u0439 \\u041d\\u0430\\u043f\\u043e\\u043b\\u0438 \\u0438 \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u0410\\u0440\\u0433\\u0435\\u043d\\u0442\\u0438\\u043d\\u044b \\u0413\\u043e\\u043d\\u0441\\u0430\\u043b\\u043e \\u0418\\u0433\\u0443\\u0430\\u0438\\u043d \\u043f\\u043e\\u0434\\u0435\\u043b\\u0438\\u043b\\u0441\\u044f \\u0441\\u0432\\u043e\\u0438\\u043c\\u0438 \\u044d\\u043c\\u043e\\u0446\\u0438\\u044f\\u043c\\u0438 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u0432\\u044b\\u0435\\u0437\\u0434\\u043d\\u043e\\u0439 \\u043f\\u043e\\u0431\\u0435\\u0434\\u044b \\u043d\\u0430\\u0434 \\u0410\\u0442\\u0430\\u043b\\u0430\\u043d\\u0442\\u043e\\u0439 (3:1).\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/spain\\/290624-primera-gostevye-pobedy-viljarreala-i-selty-atletik-silnee-levante.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290624.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 21:07\",\"title\":\"\\u041f\\u0440\\u0438\\u043c\\u0435\\u0440\\u0430. \\u0413\\u043e\\u0441\\u0442\\u0435\\u0432\\u044b\\u0435 \\u043f\\u043e\\u0431\\u0435\\u0434\\u044b \\u0412\\u0438\\u043b\\u044c\\u044f\\u0440\\u0440\\u0435\\u0430\\u043b\\u0430 \\u0438 \\u0421\\u0435\\u043b\\u044c\\u0442\\u044b, \\u0410\\u0442\\u043b\\u0435\\u0442\\u0438\\u043a \\u0441\\u0438\\u043b\\u044c\\u043d\\u0435\\u0435 \\u041b\\u0435\\u0432\\u0430\\u043d\\u0442\\u0435\",\"description\":\"\\u0412\\u0438\\u043b\\u044c\\u044f\\u0440\\u0440\\u0435\\u0430\\u043b \\u0441\\u043c\\u043e\\u0433 \\u0432 \\u0433\\u043e\\u0441\\u0442\\u044f\\u0445 \\u043e\\u0434\\u043e\\u043b\\u0435\\u0442\\u044c \\u0420\\u0435\\u0430\\u043b \\u0421\\u043e\\u0441\\u044c\\u0435\\u0434\\u0430\\u0434, \\u0421\\u0435\\u043b\\u044c\\u0442\\u0430 \\u0431\\u0435\\u0437 \\u041d\\u043e\\u043b\\u0438\\u0442\\u043e \\u043f\\u0435\\u0440\\u0435\\u0438\\u0433\\u0440\\u0430\\u043b\\u0430 \\u0413\\u0440\\u0430\\u043d\\u0430\\u0434\\u0443, \\u0430 \\u041b\\u044c\\u0432\\u044b \\u0434\\u043e\\u0436\\u0430\\u043b\\u0438 \\u041b\\u0435\\u0432\\u0430\\u043d\\u0442\\u0435.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/england\\/290623-marez-ne-pokinu-lester.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290623.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:53\",\"title\":\"\\u041c\\u0430\\u0440\\u0435\\u0437: &quot;\\u041d\\u0435 \\u043f\\u043e\\u043a\\u0438\\u043d\\u0443 \\u041b\\u0435\\u0441\\u0442\\u0435\\u0440&quot;\",\"description\":\"\\u041f\\u043e\\u043b\\u0443\\u0437\\u0430\\u0449\\u0438\\u0442\\u043d\\u0438\\u043a \\u041b\\u0435\\u0441\\u0442\\u0435\\u0440 \\u0421\\u0438\\u0442\\u0438 \\u0438 \\u0441\\u0431\\u043e\\u0440\\u043d\\u043e\\u0439 \\u0410\\u043b\\u0436\\u0438\\u0440\\u0430 \\u0420\\u0438\\u044f\\u0434 \\u041c\\u0430\\u0440\\u0435\\u0437 \\u043f\\u043e\\u0434\\u0447\\u0435\\u0440\\u043a\\u043d\\u0443\\u043b, \\u0447\\u0442\\u043e \\u043d\\u0435 \\u0437\\u0430\\u0438\\u043d\\u0442\\u0435\\u0440\\u0435\\u0441\\u043e\\u0432\\u0430\\u043d \\u0432 \\u043f\\u0435\\u0440\\u0435\\u0445\\u043e\\u0434\\u0435 \\u0432 \\u0434\\u0440\\u0443\\u0433\\u0443\\u044e \\u043a\\u043e\\u043c\\u0430\\u043d\\u0434\\u0443.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/spain\\/290622-trener-rajjo-v-ehtom-matche-net-pobeditelejj.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290622.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:45\",\"title\":\"\\u0422\\u0440\\u0435\\u043d\\u0435\\u0440 \\u0420\\u0430\\u0439\\u043e: &quot;\\u0412 \\u044d\\u0442\\u043e\\u043c \\u043c\\u0430\\u0442\\u0447\\u0435 \\u043d\\u0435\\u0442 \\u043f\\u043e\\u0431\\u0435\\u0434\\u0438\\u0442\\u0435\\u043b\\u0435\\u0439&quot;\",\"description\":\"\\u041d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a \\u0420\\u0430\\u0439\\u043e \\u0412\\u0430\\u043b\\u044c\\u0435\\u043a\\u0430\\u043d\\u043e \\u041f\\u0430\\u043a\\u043e \\u0425\\u0435\\u043c\\u0435\\u0441 \\u043f\\u043e\\u043e\\u0431\\u0449\\u0430\\u043b\\u0441\\u044f \\u0441 \\u0436\\u0443\\u0440\\u043d\\u0430\\u043b\\u0438\\u0441\\u0442\\u0430\\u043c\\u0438 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u043c\\u0430\\u0442\\u0447\\u0430 \\u043f\\u0440\\u043e\\u0442\\u0438\\u0432 \\u0420\\u0435\\u0430\\u043b\\u0430.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/spain\\/290621-benites-ne-sobirajus-obsuzhdat-reshenija-sudi.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290621.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:31\",\"title\":\"\\u0411\\u0435\\u043d\\u0438\\u0442\\u0435\\u0441: &quot;\\u041d\\u0435 \\u0441\\u043e\\u0431\\u0438\\u0440\\u0430\\u044e\\u0441\\u044c \\u043e\\u0431\\u0441\\u0443\\u0436\\u0434\\u0430\\u0442\\u044c \\u0440\\u0435\\u0448\\u0435\\u043d\\u0438\\u044f \\u0441\\u0443\\u0434\\u044c\\u0438&quot;\",\"description\":\"\\u041d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a \\u0420\\u0435\\u0430\\u043b\\u0430 \\u0420\\u0430\\u0444\\u0430\\u044d\\u043b\\u044c \\u0411\\u0435\\u043d\\u0438\\u0442\\u0435\\u0441 \\u043e\\u0442\\u0432\\u0435\\u0442\\u0438\\u043b \\u043d\\u0430 \\u0432\\u043e\\u043f\\u0440\\u043e\\u0441\\u044b \\u0436\\u0443\\u0440\\u043d\\u0430\\u043b\\u0438\\u0441\\u0442\\u043e\\u0432 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u043c\\u0430\\u0442\\u0447\\u0430 \\u043f\\u0440\\u043e\\u0442\\u0438\\u0432 \\u0420\\u0430\\u0439\\u043e \\u0412\\u0430\\u043b\\u044c\\u0435\\u043a\\u0430\\u043d\\u043e.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/germany\\/290619-bundesliga-borussija-m-v-menshinstve-dozhimaet-darmshtadt.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290619.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:28\",\"title\":\"\\u0411\\u0443\\u043d\\u0434\\u0435\\u0441\\u043b\\u0438\\u0433\\u0430. \\u0411\\u043e\\u0440\\u0443\\u0441\\u0441\\u0438\\u044f \\u041c \\u0432 \\u043c\\u0435\\u043d\\u044c\\u0448\\u0438\\u043d\\u0441\\u0442\\u0432\\u0435 \\u0434\\u043e\\u0436\\u0438\\u043c\\u0430\\u0435\\u0442 \\u0414\\u0430\\u0440\\u043c\\u0448\\u0442\\u0430\\u0434\\u0442\",\"description\":\"\\u0423\\u0441\\u0442\\u0443\\u043f\\u0430\\u044f \\u0432 \\u0441\\u0447\\u0435\\u0442 \\u0438 \\u0438\\u0433\\u0440\\u0430\\u044f \\u0432 \\u043c\\u0435\\u043d\\u044c\\u0448\\u0438\\u043d\\u0441\\u0442\\u0432\\u0435, \\u041c\\u0435\\u043d\\u0445\\u0435\\u043d\\u0433\\u043b\\u0430\\u0434\\u0431\\u0430\\u0445\\u0443 \\u0443\\u0434\\u0430\\u043b\\u043e\\u0441\\u044c \\u043e\\u0434\\u0435\\u0440\\u0436\\u0430\\u0442\\u044c \\u043f\\u043e\\u0431\\u0435\\u0434\\u0443 \\u043d\\u0430\\u0434 \\u0414\\u0430\\u0440\\u043c\\u0448\\u0442\\u0430\\u0434\\u0442\\u043e\\u043c. \",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/france\\/290620-pszh-stal-rekordsmenom-ligi-1.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290620.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:24\",\"title\":\"\\u041f\\u0421\\u0416 \\u0441\\u0442\\u0430\\u043b \\u0440\\u0435\\u043a\\u043e\\u0440\\u0434\\u0441\\u043c\\u0435\\u043d\\u043e\\u043c \\u041b\\u0438\\u0433\\u0438 1\",\"description\":\"\\u041a\\u0440\\u0443\\u043f\\u043d\\u043e \\u043f\\u043e\\u0431\\u0435\\u0434\\u0438\\u0432 \\u0432 \\u0433\\u043e\\u0441\\u0442\\u044f\\u0445 \\u041a\\u0430\\u043d (3:0), \\u043f\\u043e\\u0434\\u043e\\u043f\\u0435\\u0447\\u043d\\u044b\\u0435 \\u041b\\u043e\\u0440\\u0430\\u043d\\u0430 \\u0411\\u043b\\u0430\\u043d\\u0430 \\u0437\\u0430\\u0432\\u0435\\u0440\\u0448\\u0438\\u043b\\u0438 \\u043f\\u0435\\u0440\\u0432\\u044b\\u0439 \\u043a\\u0440\\u0443\\u0433 \\u0442\\u0435\\u043a\\u0443\\u0449\\u0435\\u0433\\u043e \\u0447\\u0435\\u043c\\u043f\\u0438\\u043e\\u043d\\u0430\\u0442\\u0430 \\u0424\\u0440\\u0430\\u043d\\u0446\\u0438\\u0438 \\u0441 \\u0440\\u0435\\u043a\\u043e\\u0440\\u0434\\u043d\\u044b\\u043c 51 \\u043e\\u0447\\u043a\\u043e\\u043c \\u0432 \\u0430\\u043a\\u0442\\u0438\\u0432\\u0435.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"url\":\"http:\\/\\/football.ua\\/england\\/290618-klopp-prinjali-mnogo-nepravilnykh-reshenijj.html\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290618.jpg\",\"date\":\"20 \\u0434\\u0435\\u043a\\u0430\\u0431\\u0440\\u044f 2015, 20:08\",\"title\":\"\\u041a\\u043b\\u043e\\u043f\\u043f: &quot;\\u041f\\u0440\\u0438\\u043d\\u044f\\u043b\\u0438 \\u043c\\u043d\\u043e\\u0433\\u043e \\u043d\\u0435\\u043f\\u0440\\u0430\\u0432\\u0438\\u043b\\u044c\\u043d\\u044b\\u0445 \\u0440\\u0435\\u0448\\u0435\\u043d\\u0438\\u0439&quot;\",\"description\":\"\\u041d\\u0430\\u0441\\u0442\\u0430\\u0432\\u043d\\u0438\\u043a \\u041b\\u0438\\u0432\\u0435\\u0440\\u043f\\u0443\\u043b\\u044f \\u042e\\u0440\\u0433\\u0435\\u043d \\u041a\\u043b\\u043e\\u043f\\u043f \\u043e\\u0442\\u0432\\u0435\\u0442\\u0438\\u043b \\u043d\\u0430 \\u0432\\u043e\\u043f\\u0440\\u043e\\u0441\\u044b \\u0436\\u0443\\u0440\\u043d\\u0430\\u043b\\u0438\\u0441\\u0442\\u043e\\u0432 \\u043f\\u043e\\u0441\\u043b\\u0435 \\u043f\\u043e\\u0440\\u0430\\u0436\\u0435\\u043d\\u0438\\u044f \\u043e\\u0442 \\u0423\\u043e\\u0442\\u0444\\u043e\\u0440\\u0434\\u0430.\",\"ico\":\"http:\\/\\/football.ua\\/images\\/football.ico\"},{\"title\":\"News1\",\"descriptiom\":\"Description\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290486.jpg\"},{\"title\":\"News2\",\"descriptiom\":\"Description\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290486.jpg\"},{\"title\":\"News3\",\"descriptiom\":\"Description\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290486.jpg\"},{\"title\":\"News4\",\"descriptiom\":\"Description\",\"img\":\"http:\\/\\/s.ill.in.ua\\/i\\/news\\/630x373\\/290\\/290486.jpg\"}]}";
        jsonObj  = null;
        try {
            jsonObj = new JSONObject(data);
            jsonObj.getJSONArray("news");
            validData = true;
            assertTrue(true);
        } catch (JSONException e) {
            validData = false;
            assertTrue(false);
            e.printStackTrace();
        }
    }

    private  void setParse(){
        Json json = new Json();
        List<PostItem> postItems = new ArrayList<>();
        json.parseJsonNews(postItems, jsonObj);
        if (postItems.size() == 0){
            assertTrue(false);
            validParse = false;
        }
        else{
            validParse = true;
        }
    }

    private  void verifyException(){
        if (validData && validParse){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }

    @Override
    protected void tearDown() throws Exception{
        super.tearDown();
    }
}