package com.hp.it.cas.match.address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hp.it.cas.match.address.engine.CharacterScript.Analysis;
import com.hp.it.cas.match.address.engine.CharacterScript;
import com.ibm.icu.lang.UScript;

/**
 * Collect test data for every script
 * 
 * @author <link href="yin-hao.liang@hp.com">Leon Liang</link>
 * @version 1.0
 */
public class StringPool {
    /**
     * Simplified Chinese test data
     */
    private static List<MockData> CHINESE_SIMPLIFIED_StringList;

    /**
     * Traditional Chinese test data
     */
    private static List<MockData> CHINESE_TRADITIONAL_StringList;

    /**
     * Arabic test data
     */
    private static List<MockData> ARABIC_StringList;

    /**
     * Cyrillic test data
     */
    private static List<MockData> CYRILLIC_StringList;

    /**
     * Hebrew test data
     */
    private static List<MockData> HEBREW_StringList;

    /**
     * Japanese test data
     */
    private static List<MockData> JAPANESE_StringList;

    /**
     * Japanese kana test data
     */
    private static List<MockData> JAPANESE_KANA_StringList;

    /**
     * Korean test data
     */
    private static List<MockData> KOREAN_StringList;

    /**
     * Latin test data
     */
    private static List<MockData> LATIN_StringList;

    /**
     * Greek test data
     */
    private static List<MockData> GREEK_StringList;
    /**
     * Common test data
     */
    private static List<MockData> COMMON_StringList;
    /**
     * Unknown test data
     */
    private static List<MockData> UNKNOWN_StringList;

    static {
        CHINESE_SIMPLIFIED_StringList = MockDataFactory.parseChineseSimplifiedData();
        CHINESE_TRADITIONAL_StringList = MockDataFactory.parseChineseTraditionalData();
        ARABIC_StringList = MockDataFactory.parseArabicData();
        CYRILLIC_StringList = MockDataFactory.parseCyrillicData();
        HEBREW_StringList = MockDataFactory.parseHebrewData();
        JAPANESE_StringList = MockDataFactory.parseJapaneseData();
        JAPANESE_KANA_StringList = MockDataFactory.parseJapaneseKanaData();
        KOREAN_StringList = MockDataFactory.parseKoreanData();
        LATIN_StringList = MockDataFactory.parseLatinData();
        GREEK_StringList = MockDataFactory.parseGreekData();
        COMMON_StringList = MockDataFactory.parseCommonData();
        UNKNOWN_StringList = MockDataFactory.parseUnknownData();
    }

    private static class MockDataFactory {
        static List<MockData> parseArabicData() {
            return populateStringList(new MockData("1185، الولايات المتحدة الأمريكية",
                                                   new Analysis(CharacterScript.ARABIC, 32, true)),
                                      new MockData("28 شباط (فبراير) 2009 - 19 ثانية/ثواني",
                                                   new Analysis(CharacterScript.ARABIC, 38, true)),
                                      new MockData("شباطؐ19 ثانية/ثواني",
                                                   new Analysis(CharacterScript.ARABIC, 19, true)),
                                      new MockData("شباطؐ19 ثانيشباطऀ", new Analysis(CharacterScript.ARABIC, 17, true)),
                                      new MockData("A\u0300\u0300\u0300BCشباط", new Analysis(CharacterScript.ARABIC,
                                                                                             10,
                                                                                             true)),
                                      new MockData("\u0300\u0300\u0300ABCشباط", new Analysis(CharacterScript.ARABIC,
                                                                                             10,
                                                                                             true)));
        }

        static List<MockData> parseCyrillicData() {
            return populateStringList(new MockData("1185ЊЩҚӘ", new Analysis(CharacterScript.CYRILLIC, 8, true)),
                                      new MockData("A185ЊЩҚӘ", new Analysis(CharacterScript.CYRILLIC, 8, true)),
                                      new MockData("A185Њ\u0300ЩҚӘ", new Analysis(CharacterScript.CYRILLIC, 9, true)),
                                      new MockData("A185Њ\u0900ЩҚӘ", new Analysis(CharacterScript.CYRILLIC, 9, true)),
                                      new MockData("A185Њ\ud804\udcb9ЩҚӘ", new Analysis(CharacterScript.CYRILLIC,
                                                                                        9,
                                                                                        true)));
        }

        static List<MockData> parseChineseSimplifiedData() {
            return populateStringList(new MockData("金科路2517号A栋2楼E6", new Analysis(CharacterScript.HAN, 14, true)),
                                      new MockData("#2517, A2, E6, 金科路", new Analysis(CharacterScript.HAN, 18, true)));
        }

        static List<MockData> parseChineseTraditionalData() {
            return populateStringList(new MockData("金科路2517號A棟2樓E6", new Analysis(CharacterScript.HAN, 14, true)),
                                      new MockData("#2517, A棟, E6, 金科路", new Analysis(CharacterScript.HAN, 18, true)));
        }

        static List<MockData> parseHebrewData() {
            return populateStringList(new MockData("#\u0300A000,10הגופן", new Analysis(CharacterScript.HEBREW, 14, true)));
        }

        static List<MockData> parseJapaneseData() {
            return populateStringList(new MockData("名古屋市東区東桜1鈴木ビル1F", new Analysis(CharacterScript.JAPAN, 15, true)),
                                      new MockData("福島県石川郡ひらたむら広町ル", new Analysis(CharacterScript.JAPAN, 14, true)),
                                      new MockData("福島県石川郡ひらたむら", new Analysis(CharacterScript.JAPAN, 11, true)));
        }

        static List<MockData> parseJapaneseKanaData() {
            return populateStringList(new MockData("ひらたむら", new Analysis(CharacterScript.KATAKANA, 5, true)),
                                      new MockData("ひらたむらル", new Analysis(CharacterScript.KATAKANA, 6, true)),
                                      new MockData("ビル", new Analysis(CharacterScript.KATAKANA, 2, true)));
        }

        static List<MockData> parseKoreanData() {
        	return populateStringList(new MockData("서울시 관악구 관악로 서울대학교", new Analysis(CharacterScript.HANGUL, 17, true)),
                    new MockData("首尔관악구 관악로 서울대학교", new Analysis(CharacterScript.HANGUL, 15, true)));
        }

        static List<MockData> parseLatinData() {
        	return populateStringList(new MockData("5555 Windward Parkway, Alpharetta, GA", new Analysis(CharacterScript.LATIN, 37, false)));
        }

        static List<MockData> parseGreekData() {
        	return populateStringList(new MockData("διαθέτει", new Analysis(CharacterScript.GREEK, 8, true)),
                    new MockData("Asdδιαθέτει12", new Analysis(CharacterScript.GREEK, 13, true)));
        }
        
        static List<MockData> parseCommonData() {
        	return populateStringList(new MockData("5555, 2-1-102", new Analysis(CharacterScript.COMMON, 13, true)));
        }

        static List<MockData> parseUnknownData() {
        	return populateStringList(new MockData("διαθέτει金科路", new Analysis(null, 11, true)),
                    new MockData("شباطؐ19 ثانية/ثواني金科路", new Analysis(null, 22, true)),
                    new MockData("A185ЊЩҚӘ金科路", new Analysis(null, 11, true)),
                    new MockData("#\u0300A000,10הגופן金科路", new Analysis(null, 17, true)),
                    new MockData("διαθέτειشباطؐ19 ثانية/ثواني", new Analysis(null, 27, true)));
        }
    }

    private static List<MockData> populateStringList(MockData... td) {
        return Arrays.asList(td);
    }

    public static List<MockData> getSpecifiedStringsByScript(int script) {
        List<MockData> sources = new ArrayList<MockData>();
        switch (script) {
            case UScript.HAN:
                sources.addAll(CHINESE_SIMPLIFIED_StringList);
                sources.addAll(CHINESE_TRADITIONAL_StringList);
                break;
            case UScript.ARABIC:
                sources.addAll(ARABIC_StringList);
                break;
            case UScript.CYRILLIC:
                sources.addAll(CYRILLIC_StringList);
                break;
            case UScript.HEBREW:
                sources.addAll(HEBREW_StringList);
                break;
            case UScript.KATAKANA:
                sources.addAll(JAPANESE_KANA_StringList);
                break;
            case UScript.JAPANESE:
                sources.addAll(JAPANESE_StringList);
                break;
            case UScript.KOREAN:
                sources.addAll(KOREAN_StringList);
                break;
            case UScript.LATIN:
                sources.addAll(LATIN_StringList);
                break;
            case UScript.GREEK:
                sources.addAll(GREEK_StringList);
                break;
            case UScript.COMMON:
                sources.addAll(COMMON_StringList);
                break;
            case UScript.UNKNOWN:
                sources.addAll(UNKNOWN_StringList);
                break;
        }
        return sources;
    }

}
