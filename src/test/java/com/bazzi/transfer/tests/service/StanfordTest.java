package com.bazzi.transfer.tests.service;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.PropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Properties;

@Slf4j
@SpringBootTest
@ActiveProfiles("dev")
class StanfordTest {

    @Test
    void testReadContent(){
        String text = "作者：马超\n" +
                "链接：https://www.zhihu.com/question/1905520976130701165/answer/1905534825798022864\n" +
                "来源：知乎\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\n" +
                "\n" +
                "又是一个深夜公告这是自3月4日以来，长和关于卖港最明确的回复！没有含糊其辞，没有在商言商，很直接，很明了昨天东大刚跟美国联合发了声明然后深夜就来这么一出你要知道5月22日才是股东会，这么早急得连夜出公告，怕是~<img src=\"https://pica.zhimg.com/50/v2-490ba465c462741a6cd5e119009975bd_720w.jpg?source=1def8aca\" data-caption=\"\" data-size=\"normal\" data-rawwidth=\"972\" data-rawheight=\"600\" data-original-token=\"v2-490ba465c462741a6cd5e119009975bd\" data-default-watermark-src=\"https://picx.zhimg.com/50/v2-505ee9917d3c92a1bdfee63c2af7dcb2_720w.jpg?source=1def8aca\" class=\"origin_image zh-lightbox-thumb\" width=\"972\" data-original=\"https://pic1.zhimg.com/v2-490ba465c462741a6cd5e119009975bd_r.jpg?source=1def8aca\"/>让我们把时间拉回到上一个深夜，3月4日深夜，李嘉诚旗下长江和记实业有限公司在港交所公告，宣布与贝莱德牵头的财团达成原则性协议，出售其全球港口业务核心资产。标的资产覆盖亚欧美洲23个国家的43个港口，涵盖199个泊位及配套的智能码头管理系统、全球物流网络等核心资源。其中涉及巴拿马港口公司90%股权。李嘉诚此次要卖出的港口分布在亚洲和大洋洲的有21个，分布在欧洲的有13个，其中许多的港口的重要性并不输于巴拿马运河港口。比如荷兰的鹿特丹港，每年要处理超过1380万集装箱，占了欧洲市场的42%，如果鹿特丹港被美国贝莱德控制，咱们对欧出口的汽车、光伏组件等商品都可能被“卡脖子”。但是在这么重要的港口交易，涉及全球战略资产，没有全球公开招标，就要一声不吭卖给美国。东大“一带一路”国际港口体系110个左右的港口格局，如果这场交易被成功出售，那么支撑东大整个外贸体系的“一带一路”港口体系恐怕要被牵制与掣肘，蒙受很大损失。一石激起千层浪消息一出，香港《大公报》自3月13日起连发三篇\"炮轰\"文章，直指这笔交易\"威胁国家战略安全\"。3月28日香港《南华早报》消息：“下周不会正式签署有关两个巴拿马港口的协议”。同时指出：4月2日并不是“真正的最后期限”，而只是一个可以签署协议的“最早日期”。《南华早报》报道称，没有迹象表明该交易已被取消，由于交易的复杂性，重要细节尚未确定。4月2日，李嘉诚在这个可以签署协议的“最早日期”上玩起缓兵之计！4月25日某个会议召开，对与美国的贸易关系，对美国发动的关税战和贸易战，有了新说法，即“国际经贸斗争”，这也是正式给李嘉诚与贝莱德之间的港口交易进行了政治定性。4月27日，国家市场监督管理总局正式出手，发布消息称，长和港口交易各方不得采取任何方式规避反垄断审查，并将依法进行审查。交易各方不得采取任何方式规避审查，未获批准前，不得实施集中，否则将承担法律责任。5月6日，在外交部的记者会上，有记者提问，有媒体称，长和获准出售巴拿马运河港口以外的港口。请问有何评论？东大：这一报道没有根据。国家市场监督管理总局已经表示，高度关注有关交易，将依法进行审查，交易各方不得采取任何方式规避审查，未获批准前，不得实施集中，否则将承担法律责任。中国政府将依法坚决维护国家主权、安全、发展利益，维护市场公平公正。企业商业行为应遵守相关法律，不能损害国家利益。背后有三点要求一，“未获批准前不得实施集中”。意思是，必须接受审查批准，也就是你先申请，批了才能交易，否则就是违规。二，“不得采取任何方式规避审查”。就是指谁要采取“化整为零”规避手段，行不通，堵死！三，“承担法律责任”。要敢违规，吃不了兜着走，面临包括行政处罚，交易叫停，信用惩戒等处理。这就彻底断了李嘉诚把业务一分为二耍小聪明然后，随着昨天东大的会谈较为顺利2025年5月12日深夜，长江和记实业有限公司发布声明，强调其全球港口资产交易“绝不可能在任何不合法或不合规的情况下进行”。在整个事件中，李嘉诚和长和的表现，堪称教科书级的玩商业套路。知道自己打包卖给美国贝莱德实在激起公愤，玩起了“一拆为二”的把戏，再试图用分别卖的形式来规避调查（将交易规模切割至申报门槛以下，试图绕开中国《反垄断法》的审查范围），由此暗度陈仓让美资掌控绝对主动权。一句话，就是要卖。<img src=\"https://picx.zhimg.com/50/v2-ed0074fe3a97f63f468679a578fad86a_720w.jpg?source=1def8aca\" data-caption=\"\" data-size=\"normal\" data-rawwidth=\"517\" data-rawheight=\"639\" data-original-token=\"v2-ed0074fe3a97f63f468679a578fad86a\" data-default-watermark-src=\"https://picx.zhimg.com/50/v2-b3ab84406941d951689d6ab9b13d16d2_720w.jpg?source=1def8aca\" class=\"origin_image zh-lightbox-thumb\" width=\"517\" data-original=\"https://picx.zhimg.com/v2-ed0074fe3a97f63f468679a578fad86a_r.jpg?source=1def8aca\"/>其实，招商局组织的财团很早就想从李嘉诚手里把这些港口经营权买回来，开价也很高，但李嘉诚一直不卖。这件事情其实可以看出，李嘉诚不缺钱，缺的是家国情怀，他把港口卖给美国资本的决心非常大，为此不惜尝试各种办法来突破或绕过国家反垄断审查。一面强调着“在商言商”的论调，一面做着“在商不言商”的决定，动荡之下，李嘉诚也在为李家寻找的退路——分头下注，无论最后怎样，李家总能保存实力。长和集团发布这样的声明，有可能是权宜之计，毕竟当下，东大已经介入，李嘉诚只能跟着官方的步子来。毕竟这时候继续推进相关事情的话，很可能会引发更可怕的后果。发布这则声明，不仅可以暂时平息舆论，也可以为该公司争取更多的时间去做决定。不过，既然作为一名企业家，应该有自己的底线资本是逐利的，但在国家战略安全面前，必须守住底线。资本无国界，但资本家是有国籍的。在关键时刻，态度和立场尤为重要。资本有自由，但这种自由不是绝对的，而是在法律框架和国家利益边界内的自由。<img src=\"https://pic1.zhimg.com/50/v2-060f1b06baba1049420eebc2c349279b_720w.jpg?source=1def8aca\" data-caption=\"\" data-size=\"normal\" data-rawwidth=\"1063\" data-rawheight=\"574\" data-original-token=\"v2-060f1b06baba1049420eebc2c349279b\" data-default-watermark-src=\"https://picx.zhimg.com/50/v2-2f8d77f34ec6d1652068acd0c23f2614_720w.jpg?source=1def8aca\" class=\"origin_image zh-lightbox-thumb\" width=\"1063\" data-original=\"https://pic1.zhimg.com/v2-060f1b06baba1049420eebc2c349279b_r.jpg?source=1def8aca\"/>";

//        StanfordCoreNLP pipline = new StanfordCoreNLP(PropertiesUtils.asProperties(
//                "annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref",
//                "ssplit.isOneSentence", "true",
//                "tokenize.language", "zh",
//                "segment.model", "edu/stanford/nlp/models/segmenter/chinese/ctb.gz",
//                "segment.sighanCorporaDict", "edu/stanford/nlp/models/segmenter/chinese",
//                "segment.serDictionary", "edu/stanford/nlp/models/segmenter/chinese/dict-chris6.ser.gz",
//                "segment.sighanPostProcessing", "true"
//        ));
//        //创建一个解析器，传入的是需要解析的文本
//        Annotation annotation = new Annotation(text);
//        //解析
//        pipline.annotate(annotation);
//        //根据标点符号，进行句子的切分，每一个句子被转化为一个CoreMap的数据结构，保存了句子的信息()
//        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
//        //从CoreMap 中取出CoreLabel List ,打印
//        ArrayList<String> list = new ArrayList<>();
//        for (CoreMap sentence : sentences) {
//            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
//                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                // this is the POS tag of the token
//                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
//                // this is the NER label of the token
//                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
//                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
//                String result=word+"\t"+pos+"\t"+lemma+"\t"+ne;
//                list.add(result);
//            }
//        }
//
//        log.info("stanford分词结果：{}", list);

        StanfordCoreNLP pipline = new StanfordCoreNLP(PropertiesUtils.asProperties(
                "annotators", "tokenize,ssplit,pos,lemma,ner",
                "ssplit.isOneSentence", "true",
                "tokenize.language", "zh",
                "segment.model", "edu/stanford/nlp/models/segmenter/chinese/ctb.gz",
                "segment.sighanCorporaDict", "edu/stanford/nlp/models/segmenter/chinese",
                "segment.serDictionary", "edu/stanford/nlp/models/segmenter/chinese/dict-chris6.ser.gz",
                "pos.model", "edu/stanford/nlp/models/pos-tagger/chinese-distsim.tagger",
                "classifier", "edu/stanford/nlp/models/ner/chinese.misc.distsim.crf.ser.gz",
                "segment.sighanPostProcessing", "true"
        ));
        //创建一个解析器，传入的是需要解析的文本
        Annotation annotation = new Annotation(text);

        //解析
        pipline.annotate(annotation);

        //根据标点符号，进行句子的切分，每一个句子被转化为一个CoreMap的数据结构，保存了句子的信息()
        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

        //从CoreMap 中取出CoreLabel List ,打印
        for (CoreMap sentence : sentences){
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)){
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                String result=word+"\t"+pos+"\t"+lemma+"\t"+ne;
                log.info(result);
            }
        }

    }

    @Test
    void testEnglishContent(){
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, sentiment");
        props.setProperty("ner.applyNumericClassifiers", "false"); // 关闭数字实体识别（可选）

        // 2. 创建 StanfordCoreNLP 对象
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // 3. 定义待分析的文本
//        String text = "Stanford University is located in California. It was founded in 1891.";
        String text = "Stanford University is located in California. It is very bad school";

        // 4. 将文本封装为 Annotation 对象
        Annotation document = new Annotation(text);

        // 5. 执行分析
        pipeline.annotate(document);

        // 6. 提取结果
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            // 打印句子原文
            System.out.println("\nSentence: " + sentence.get(CoreAnnotations.TextAnnotation.class));

            // (a) 分词与词性标注
            System.out.println("\nTokens & POS Tags:");
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.printf("%-15s %-5s\n", word, pos);
            }

            // (b) 命名实体识别（NER）
            System.out.println("\nNamed Entities:");
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String ner = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                if (!ner.equals("O")) { // 过滤非实体
                    System.out.printf("%-15s %-10s\n", token.word(), ner);
                }
            }

            // (c) 句法分析树
            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            System.out.println("\nParse Tree:\n" + tree);

            // (d) 情感分析 Neutral\Positive\Negative
            String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            System.out.println("\nSentiment: " + sentiment);
        }
    }
}
