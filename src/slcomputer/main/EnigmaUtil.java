/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.main;

import slcomputer.runnable.SocketMaster;

/**
 *
 * @author J
 */
public class EnigmaUtil {
    public static int checksum(String s){
        int sum=0;
        for(char c: s.toCharArray()){
            sum+=c;
        }
        return sum%10;
    };
    
    /*
    
    
    Balance space
    
    
    */
    public static String checkVip(String usr, int count){
        String[] myvip={/**/"adf3a08b5ba2b4de0f2059c1ce5e940b0e6c3f499b437449", "48eccc3144a6e6e219410fc72b583b77bf99942c097325e411002880726a9c04",
                "3b09935ab315abfe0e726668044a274a", "d30a78c24ba8fb5a2f2adf5ca8dfe8fe58159cd00c8dc8fd", // 客观的苍
                "cda10db2bcf27b387f5e513568e6f2810e6c3f499b437449", "25502f6aa1aea034622028d786cb3172b23987ccb052acd4de99c67a250dae07", // 队长
                "64b72dd8fca10b501fb93a5807de4b0a792b4717e7c5b82f", "225d6d0a52c3758bbb428f70ddfc9c8d7e1ad5c998bfa2e8", // 雉鸡油奶
                "cb43174fd03ed6806169fb07a0bcd03c", "14c00cdc4a5ccb46f31448d367bcf597b4585aa359a02c0a", // 吐吐
                "71fd54d8efab4ca75c089891c09ecea3896db44fb926a25b", "14c00cdc4a5ccb467e564c571341869b1fb93a5807de4b0af82d0ac7f152fdf8", // 吐吐
                "cad8aff679c01be6fc609ae8dc7da6c8", "38174cbd299f2acbcd13187db19fe7db442c263feca0a2f7", // 吐吐
                "7a92cd7838cf91697f55f817429f0f957bdeba206119285a", "490b8cd46071247524cc957b10830e2a70bfdf8b2fbb29c7792b4717e7c5b82f", // 吐吐
                "2b5dfc233269e88ec9649cc854c00de2896db44fb926a25b", "d8553533d019efdad1c4a2b89dd0c1e61fb93a5807de4b0a54882121955904cd", // 青苑
                "8f2fa65804fc1c4cce7cefedf89d623b792b4717e7c5b82f", "9c98eac2312e3cf866e130b66b47e76171bc4df3af655e1b", // 海天隐神1203
                "adf3a08b5ba2b4de78d824a4a8f11df0df4f9f17ab7a9e21", "48eccc3144a6e6e219410fc72b583b77333e2f24c0854c49506adbf93d767374", // 测试小号
                "ae962dacfdfeb90af93963238cda7380", "7dff8bc041f8bab74248ba13da9b84b5792b4717e7c5b82f", // 安卓91 1113
                "e1f6663a678d20011fb93a5807de4b0a792b4717e7c5b82f", "c36f902c1da57eedfcf588aaf86669b83b5bea4965ed3a38", // 派大星
                "81a62214b0e522408a1e54d926df55997bdeba206119285a", "9f5af1a16f99a68572d50a4b3ce0a2d6e4fc1f5477f501fc792b4717e7c5b82f", // hero京k
                "6c870553e983466ae2eade6614fed130792b4717e7c5b82f", "cd306fb8b0e5c081c1723fe86a39f6e271bc4df3af655e1b", // app 1114
                "486fd3239adca28b6eb8d6e588a0b1de792b4717e7c5b82f", "94b105802a3bf9868ce785ac2a95d02de61e5833c3e17e57", // app 1126_3
                "486fd3239adca28b6eb8d6e588a0b1de792b4717e7c5b82f", "8bb39860490206eebc83c3318d0721faf93963238cda7380", // app 1126_3 改
                "bb3d83e56326d8f557c1a3d9ed967ad0", "993fe7d4bf9fd666a770f5d5970b55726fe84f703a3db448", // app 1110_3
                "befefc61d6d78b8357c1a3d9ed967ad0", "45ec799b49d4252da541e97116759656a3cd2dd0f8f896a6", // app 1110_3
                "be96812db1eea4ac0379a1b99e09efd7", "bde0181d9f1df9a75cb88252e2ae5aff06da5047a0d0dbff", // app 1130
                "0596ad1088673146fc609ae8dc7da6c8", "380610d515ccc58aa235dd046d515fd17ecbe857d86edcf5", // app 1126_3
                "e22ab43eb4fe5289a03d986f62ea6176792b4717e7c5b82f", "9143da58d9974488a3243e4517111cd73e35a3a103e7cd9c", // app 1110_2
                "a68935d7503eef35e2eade6614fed130792b4717e7c5b82f", "1b775677cd1235c8381d203a2262b6c471bc4df3af655e1b", // app 1126
                "3ef6765cf6990fa9792b4717e7c5b82f", "629d4d70126743e4f3b682beedcd88f7792b4717e7c5b82f", // 安卓91 1120
                "373c41a9ae1fb9025c4822926b1ed6d9", "71cce3f29350d665d07f1a969764aa33792b4717e7c5b82f", // app 1130_2
                "bb2b3d53f40aa3f01de5f6b2c8b18d23896db44fb926a25b", "f2d4249a58b15f6f6f3eb20e61dc96e5b3c9cb5d279888785c4822926b1ed6d9", // app 915
                "bb8551f576be28ef3662da4685913df97bdeba206119285a", "d8553533d019efda965bdc8dafb86895b764cdc00a79af0a792b4717e7c5b82f", // app 810_2
                "cd5746ab0ed3aa9f49cbe9d307ac7fd6c4d9babcce10a999896db44fb926a25b", "32383e4428f25512ed1e562e99dab8890aa7ee6f084e0eae229c057fe83cd596d933927383ee50d3", // app 820
                "e44a9c9fa37971be0313de0b2b3fb9fa", "1d8f866d4e15f197e852bb04ce09fd9557f805f0ef066e93", // app 816
                "75086f4986334e2bfa68567e2cc32b8c0e6c3f499b437449", "a5d55face9f25b071499821a377f7967cbdd04b79fbc7eb937b1e8a1b7b9efa2", // app 816
                "ece53dbfbfa521c16169fb07a0bcd03c", "037f9eb7e4a637f3fffc36082f45ee1bf9337af1aaf715bf", // app 816
                "cb4d8a98f0eed1bb95d984ccb7dd0d7b", "ef7334693cec046f4fcf3eb78db657f5792b4717e7c5b82f", // 安卓91 1206
                "1fd6c27e8d1fef0da034a7e7f4c090cc", "0cb854e5a7b8ca643f16a89889a8f85ca18bb5676c58b562", // 安卓官方 810_2
                "db5bbdbf1b60fd3f9abae4f84c85e185", "0cb854e5a7b8ca64b13f2e7914d6e2fb61f69563d4cad936", // 安卓官方 1110_4
                "6b66be71ee6d620dc8d7ca48faed23fa", "df57a4a5f308b390eb4ece853b13f8b0b9be25372831774b", // 安卓官方 1067200406@qq.com
                "ab6fbbd84fcc05a5b00ea49f752ac4df", "0cb854e5a7b8ca64c1c2b0ef1992403bae56236d92b42d96", // 安卓官方 1206
                "b2dc6c2f2e71361e5c4822926b1ed6d9", "7f0ba163bc529b065f8605d854972f2e792b4717e7c5b82f", // 苹果91 373324498@qq.com
                "af04145b7668c16bd933927383ee50d3", "2bcb75840125b2fc72c039bbb6891d367db3af7c7709fe60", // 安卓官方 816_2
                "94d419cc2c6ab95bc7d32219f85460487bdeba206119285a", "f2d4249a58b15f6fac3f567444ec8f82e62f15028b3ce85f792b4717e7c5b82f", // app 1119_2
                "6b2960eb552ae0fafc609ae8dc7da6c8", "490b8cd460712475893eecb10c686a173b80a383476e9916", // app 1119_2
                "6ffd6465c9a323b4297ccc304a073491792b4717e7c5b82f", "16514342a2db5bd2c221e685ed308db3679780e6a46df7d1", // app 1119_2
                "3d9387097d23006cfc609ae8dc7da6c8", "f4ff95efcc0045297899134057f9d56d7ecbe857d86edcf5", // app 506
                "7f52de536e2cf309fc86b5bce4c00857", "f5299ea256db907f727cacaf73b5686c792b4717e7c5b82f", // 苹果91 1123
                "ba2365df5fb5220de9781f752361d8d0792b4717e7c5b82f", "348bf760cf5c12099725aebf354638d5e5099019b53553da", // app 729
                "e4bf3d88c3d86e7e2da15d48e6283fbb", "c4710aec5b292d089ecf580b1b8cd78f84838f7c0953700c", // 安卓官方 807
                "753b2a3d406b9abd33d7f0ba7c12b57c", "3f410325d76797fbd7631904276068a2", // 安卓豌豆荚 807
                "b9ba2dfd91761633d4f4d4173c703eed792b4717e7c5b82f", "43db457b7b183260b8da6c274f1ef0a4cdbf72c0d546993c", // app 1303
                "ebcd8ca00785e62c", "d411fe1e006214441540aba060b91d1f", // 安卓官方 1110_6
                "563ae305833f60de792b4717e7c5b82f", "d411fe1e0062144430ebe5a29e6d1ab0792b4717e7c5b82f", // 安卓官方 1110_6
                "41f3626f7db425b69abae4f84c85e185", "0cb854e5a7b8ca642f17696b3eeeaa9d4cb432e33ea48a5f", // 安卓官方 1111_2
                "2c8ea705990c99d36e62dafc6be4c0f6", "4e62caa539946e196c6ea4a3b0b71ad3", // 安卓豌豆荚 1206_2
                "5fee406e37c566462d5773e5eeef6bfc7bdeba206119285a", "47c2a9a14c5040cb74b1fab465684f2b1256f7c7e380ffd9792b4717e7c5b82f", // app 1208
                "13beca709ab376eaf93963238cda7380", "f8b66cdb8b73534e217f091c36ee683a792b4717e7c5b82f", // app 1111_2
                "ab7212b4299a81528658d1660c421e85792b4717e7c5b82f", "bdf9e20d766386b4fa4295320932b153d15a11bf118a5083", // 白色风车
                "de049bd5f90eb888", "a280deb9ca54e12ed1fc4643577c0685", // 同步推 704
                "5286a3dc0e624831d4cbe672327863cb", "6675566c7684aa81e42c70580b03992c", // 同步推 811
                "dd28f6497d2a8779e03674d3f07dc25b", "53a02c9766178081f7579f5de1af7fa954882121955904cd", // 安卓360 1128
                "9ab201d3ccb0a141ca53788e74b91101", "acbeae9a8a16c316106b746308a8fc40", // 同步推 623
                "8fba5c6606f2280cbc83c3318d0721fa792b4717e7c5b82f", "acbeae9a8a16c316b41dc4f3534923ca", // 同步推 623
                "69deb023d2c06d34", "a280deb9ca54e12ed0d0fd76491ef2ce", // 同步推 704
                "7d48ec50e1e1b64b8e301f4640085ff5", "299ab10560fa3402099d3a207203e083792b4717e7c5b82f", // 苹果91 1111_3
                "7d48ec50e1e1b64b90b8f9572ddf914f", "d146b8019f6b3a58c80cd195ca928722792b4717e7c5b82f", // 苹果91 1111_3
                "6a2c5b94331d1840792b4717e7c5b82f", "22fc5305bf142c82d4c29cde47b12b00", // 同步推 1111_5
                "ae09f33b31cb39e96eb8d6e588a0b1de792b4717e7c5b82f", "89dc0bac350233031ee53d5501b60486e61e5833c3e17e57", // app 811
                "52a3c3ef7767d46a617b78b4431d379d", "0cb854e5a7b8ca649fad22b51e4a68e5dfa6ceab458712c6", // 安卓官方 711
                "3a7d984cb9e1de11e5dcfff0e06f795a7bdeba206119285a", "f06f270a4b73c8e46296748e1e09449ac0f7fdce9d7dd6c7792b4717e7c5b82f", // app 1209
                "283daa32f6e0f220a871c937bc0e53b0", "6675566c7684aa8110f1e89e56e1dcf5", // 同步推 811
                "f531fb2c8e0fef56792b4717e7c5b82f", "c4871494c9cbd9ecc1f452124bd98e1b", // 苹果91 1209_2
                "9f08662438d2f875f99d632dfe48e7ee", "34955b793e0288ecc1514219b21711b0", // 豌豆荚 1209_2
                "91d8879c8468050cd6fa2eb3b588f7e3", "3597b2868e49c5c092f429ae9cac8402792b4717e7c5b82f", // 安卓91 1209_3
                "80a187d2c3da12778287270cb707b67c", "02f47d5166f785d6e2433a539eb16b48792b4717e7c5b82f", // 安卓多酷 1067200406@qq.com
                "550b0909f38660578d119c3a2922bca97bdeba206119285a", "3bbbdbde442347eb6255491a8da8fd018583816d6852aa13792b4717e7c5b82f", // app 1209_4
                "e22372205082abaad4f4d4173c703eed792b4717e7c5b82f", "67d14f7aa50b136b9bcd6fe3114943dae5099019b53553da", // app 1209_4
                "57436f3d6505a305d4f4d4173c703eed792b4717e7c5b82f", "ff5d6261d4d4a426ec9bab4df042c568679780e6a46df7d1", // app 729
                "bbf5017ad19e855b792b4717e7c5b82f", "8a51e78261cd1b402ebd128a243649cb", // 安卓多酷 1209_2
                "db687a8b4b145cee", "417ed46f43fa84ceb0d26fa22c0bc7a6", // 同步推 混61288039
                "dde6ce56c214868b6eb8d6e588a0b1de792b4717e7c5b82f", "43f7eb23d15e1a00be98750672d7db2854882121955904cd", // 新浪 混58705770
                "9a2346eb8006851e", "835a3fefb33718d7b3ffa591fcb5c196", // 同步推 1110_3
                "2ea76234ca7833c8", "005dbad0e78477895fdd8915463ef059", // 安卓官方 1108
                "9cbb6b5b31c6072ed22dfe9208e400917bdeba206119285a", "639a422ba124f500c7a718e2813f2d99", // 豌豆荚 1108
                "805349fc3298e887956380f8c7875b6e", "2545319fc87fafee1aed7df927fd5fed792b4717e7c5b82f", // 安卓360 619
                "550b0909f3866057c24ee3c5a442d775896db44fb926a25b", "3bbbdbde442347eb6255491a8da8fd01e2eade6614fed130fc86b5bce4c00857", // app 1209_4
                "417169569f23159e7b8f34a707a12a23", "cee9c9405b87da43947a2a31df1825e3792b4717e7c5b82f", // 苹果91 1212
                "743637835fefffbf", "0148ab3fe3314fddb9d5533c7ddad0b4", // 安卓多酷 807
                "d142373a748d600357c1a3d9ed967ad0", "f9dac7b77a825c6a65eb5732dc76cee2fc39e3298d4dfefa", // app 1215
                "f2cf6579e63de76ce0371f5a00f107ae", "f9dac7b77a825c6aeedd2bc37a4e4dcd02235ec4ce5188a3", // app 1215
                "b9145940fc9222a75b1226679ff3daef", "de64176e908655f40b92e38ba1353bb0", // 豌豆荚 1216
                "87b0aebb11f1a60228f01650a3943329", "cd3ea4accbe3ed7fbc83c3318d0721fa6c91194213444030", // 苹果快用 1218_3
                "676a8e887a1d663d464e423d584f61ab", "f90fde566949c8fa48a1bfc81f886a24792b4717e7c5b82f", // 安卓360 1216_2
                "9837213e4e0dd50ec3e6b9fc3804e704", "256702a42f6e81036ffc381ee7fad17f", // 同步推 1216_2
                "1779509b8f77273e6c91194213444030", "d146b8019f6b3a58c508ed206947cf71792b4717e7c5b82f", // 苹果91 1218
                "6833fbaa05a538ac792b4717e7c5b82f", "560df42700b33376cc60c56900fc11cf792b4717e7c5b82f", // 安卓91 1218
                "eee2d417501b5458012931b687753757", "efaecb0c6a7520e0cc07f1d853cc8783792b4717e7c5b82f", // 安卓360 1218
                "a80ec5bdd8526e98ce7cefedf89d623b792b4717e7c5b82f", "be990acd9e2c9f25247a52a14486c521", // 同步推 1123
                "10ab15d39dbef0bb8e2b331ecc0a4cc3", "34b59fde1cfc359734394275dfc18368792b4717e7c5b82f", // 苹果91 1218_2
                "20122ac13a98204f8650a238a8417a74", "8a41b31a3cdff94dc865d3d879967f9c792b4717e7c5b82f", // 苹果91 1219_2
                "56d4f568e7755cab", "6dec51b9a4ba099dd03c19c3477b3fbb792b4717e7c5b82f", // 苹果91 1219_2
                "0e482455336fd0608650a238a8417a74", "8a41b31a3cdff94d614ffcd9fc4ab3b4792b4717e7c5b82f", // 苹果91 1219_2
                "ab5cd18cadd25471fc609ae8dc7da6c8", "894e2eacd16633351145bb8de05dfe52", //同步推 1219
                "470b2e8c07317fd7", "2146af74e417255dee08cb0ab226d1e0", // 安卓官方 1221
                "e0332ef72686b4bb2f6a1f3ad07cd753", "8ed0dc5cd832e20ecf31a83f92d5917d", // 同步推 1221
                "dde9ca6f04ccbc32", "8b0cadf7c01591410dcc1f08d0e4e929792b4717e7c5b82f", // 多酷 1222_2
                "bf533428c48249d2", "82919c5db5763a8d630686bc7aaaefa0", // 同步推 1222_2
                "7e17c9b77435cc7c7b8f34a707a12a23", "f6ebbf35bd90ca9bb4e3f3a0f6f0802e792b4717e7c5b82f", // 苹果91 1222_2
                "7d48ec50e1e1b64b9f1e1f7aefb9c7c0", "299ab10560fa34024346864c290139b1792b4717e7c5b82f", // 苹果91 1111_3
                "7d48ec50e1e1b64bef66425f4abdb443", "299ab10560fa340266f31ada6722cfa0792b4717e7c5b82f", // 苹果91 1111_3
                "7d48ec50e1e1b64bd3af0288d8b5ad37", "299ab10560fa3402b91cb3c106e36f27792b4717e7c5b82f", // 苹果91 1111_3
                "7d48ec50e1e1b64b72cf6150ae657f8b", "299ab10560fa34027222328608db00d5792b4717e7c5b82f", // 苹果91 1111_3
                "7d48ec50e1e1b64b7f2be525fd8f8044", "299ab10560fa3402eb2908a102bef2a8792b4717e7c5b82f", // 苹果91 1111_3
                "7d48ec50e1e1b64b06886d1b1e26e148", "299ab10560fa3402217cbe808bc191bd792b4717e7c5b82f", // 苹果91 1111_3
                "cb4d8a98f0eed1bb7371b237c6a6efa9", "f160005aa751a148eb243c4ad160edc5792b4717e7c5b82f", // 安卓91 1206
                "7d48ec50e1e1b64bf61ada2c47d5fa4a", "299ab10560fa3402f1b5600077eb2649792b4717e7c5b82f", // 苹果91 1111_3
                "7d48ec50e1e1b64b1f4d60d9df2b99fe", "299ab10560fa340210e5df2f65017942792b4717e7c5b82f", // 苹果91 1111_3
                "f7ef70d3570a468554882121955904cd", "3a8cc69f9ce6185e0ad8757c07c600c75c4822926b1ed6d9", // 安卓官方 1227
                "339f1cf366d64d0ea03d986f62ea6176792b4717e7c5b82f", "0c1d0be03df53f15a60faed1b6d362e346a31f10fb426b39", // app Hero京k
                "ab67c5a490bac0eb23b4cc3b3a570165", "ef22ede47171aea3f0acefdf59b7b9ef", // 豌豆荚 1206_2
                "0a468c40caddc48ee9781f752361d8d0792b4717e7c5b82f", "041f9d8b87ca760f59dff4d074fe2fe9a9355985b2063285", // app 1119_2
                "66d03250ef80f8fa5c270bbad40e982b792b4717e7c5b82f", "07d0c98e6ab7f0b2e7444cf6cbe60734d15a11bf118a5083", // app 1119_2
                "113892b28e15970a6169fb07a0bcd03c", "19c6fa4742ff1979956ab3daf71667f4494e436f26bc996d", // app 1119_2
                "91fdcc84cc90d2718658d1660c421e85792b4717e7c5b82f", "8388512d44c3cae2bb6a5dcd615130a0679780e6a46df7d1", // app 1119_2
                "834fac0d873fe512fc609ae8dc7da6c8", "df0cf3ddf529a61d39da7a090d1e620c3b80a383476e9916", // 湮灭
                "ee2c88c8311e75db792b4717e7c5b82f", "7f148d64dde87934a79b755b031b3d0e", // app 1119_2
                "59f70675e9691ac76169fb07a0bcd03c", "ea31f739fea69185934c042fb5d942e263cca11edd933224", // app 1119_2
                "408c0f3d871e528dd4f4d4173c703eed792b4717e7c5b82f", "37d1bcb816955036c2c14b92e2b6aef1a9355985b2063285", // app 1303
                "33b57de8aed9e88c792b4717e7c5b82f", "e881eda7e70db8ec66b285689872d7ee64bdb7f1b71108a2a9025b6b3d141119e7c1d2afad954b43", // 应用宝 1207
                "c15c2677e90072d040f53c3e1d6b5021", "4ad491baaa892fb5d3e1a55cd855d7f97cd13473fe4a5ef3", // app 1303_2
                "a596138c2cff5494e0371f5a00f107ae", "4ad491baaa892fb56e4fe0ccaceea2440379a1b99e09efd7", // app 1303_2
                "9f877dc3f336ede2792b4717e7c5b82f", "4e71167c8065007cf10b3eac6b962676792b4717e7c5b82f", // 安卓官方 621
                "78777dce60690ab8896db44fb926a25b", "629ac87a56238570ce6d016db6fdadc55c4822926b1ed6d9", // app 1304_2
                "78dd76a226e098af", "36b28424153432f5717e0f5a7c5b017d", // 安卓官方 1304
                "694e1a6d9aede331", "a5b011a61cd4e9ecb380b75dcf0ba2d0", // 安卓官方 1304
                "cb773c9ae440953aade889759f6830c3", "40a177de836b33e660443364ce633a09792b4717e7c5b82f", // 安卓360 1304
                "178d0fe9846b653cf77c36cdb37e8a0a0e8bb46bb66f9bb6", "7e3947c1dfa728fc9894b2ff3deb0eaf45a6ef34649f6cc6c76b7f812871043c", // app 湮灭
                "27ae724779c2b83f57c1a3d9ed967ad0", "95bb832e384c7806ba7ad46ba0f45a602e7349c1a4352958", // app 1305
                "55b9d6b8430076b2bd5bb8588fb8b7a77bdeba206119285a", "48eccc3144a6e6e226f28e9c3182caf52ad427d3a129dbd4792b4717e7c5b82f", // app 1303
                "08fb00f6b263bfcf", "0ea5cad06279735cd9063982407f2fd8", // app 1306_2
                "53a00cfb4c096c8ca963fbd34da4a072", "e7ac3669a8d5b6982357a80f7cec0638792b4717e7c5b82f", // app 1306_2
                "afd46100f923494af4b498df8286b4ce", "d3c4994f4026288902668e29925947ae", // 同步推 1306
                "e37b8805a24e02db54882121955904cd", "a8e66a3ea58e820dabd8bcefb26225033d2a3f4d824f88fc", // 苹果快用 1309
                "63c50650971e43b4bc83c3318d0721fa792b4717e7c5b82f", "f96d0b778e7bc2df8dce640c90f9b361792b4717e7c5b82f", // 安卓360 1305_2
                "d8de78429af9de885c270bbad40e982b792b4717e7c5b82f", "4ecea3b1ec9db5af08587f8033d00997", // 同步推 1310
                "354f8a05c6e4f265c7715ca4269a036b7bdeba206119285a", "29f7d4c83b1dbcd44e29a57820f1c877dcad588024763f157b8f34a707a12a23", // 安卓官方 1111
                "e54fe53653474769f3f4fd038c1c9549", "d146b8019f6b3a58d22f924614bdfb78792b4717e7c5b82f", // 苹果91 1311
                "1ceacb95deeb960b2da15d48e6283fbb", "8a41b31a3cdff94dba9c2e64eaa4afeb792b4717e7c5b82f", // 苹果91 1311_2
                "5aaf9c20f87bf043f51888eea6094795", "af9e15e3dea2e53bdb63f0ae15fa433f", // 苹果pp 1311_2
                "9281b3e4307be00316d5d3fedaca8f4c57c1a3d9ed967ad0", "192f06cb7292a5b8a109f68cf78be62e0a7c067c9888c8768fecdc1eab75f2ba", // app 729
                "15567a26c55f7f0ee9781f752361d8d0792b4717e7c5b82f", "86dc129b1add3c2c96547f9bb0cda7fda9355985b2063285", // app 512
                "29128fbb360b54bff93963238cda7380", "79a903a00eb3b0e343df4e270c32728c792b4717e7c5b82f", // 安卓91 1310
                "d57097b15f693e5f956380f8c7875b6e", "2157a314dd1bee753b8d11e0b9cc944c792b4717e7c5b82f", // 苹果91 1310
                "135ffb3ed7d0df9154882121955904cd", "0229ac33e81ff717b5db497dcbe76806d933927383ee50d3", // 安卓官方 1313
                "9dbf02f5e60716e3", "f714a4e35507380b69f1c22dd42ad099792b4717e7c5b82f", // 安卓360 1313
                "e73c4eca9bead0ef6592044ce2e86fca", "417ed46f43fa84ce76aec28b49370797", // 同步推 1313
                "41ec3135a6b9d0245a55ee61b73be852", "3597b2868e49c5c00710308c9f3f35a2792b4717e7c5b82f", // 安卓91 1310
                "18d314ce647d109654882121955904cd", "7dff8bc041f8bab7e0335f221d2f68ce792b4717e7c5b82f", // 安卓91 1310
                "886e8edead6253c6fc86b5bce4c00857", "3597b2868e49c5c06ba81bbafa7a80e3792b4717e7c5b82f", // 安卓91 1310
                "49e8202772e60cc2768eecd4f992be6357c1a3d9ed967ad0", "207a3ac06e6bd51f1e4cf8a5cff65140", // 混邮箱杨烈
                "784a0cd095fb24e6fc609ae8dc7da6c8", "730ad02b147a03c10f19375437f403f70a9c1a03c2ab4bd9", // app 1314
                "22e136d08a33459b", "8019bd19617e247f9fcfd444f628a373", // 安卓官方 混邮箱杨烈
                "31ffb4d6750ce027", "417ed46f43fa84ce29701dc9ca1ca0a2", // 同步推 623
                "0a0e0cf19c2ac1535c270bbad40e982b792b4717e7c5b82f", "ead9022c1413379e5ab4b01a95803e3c0af2668ab12d9735", // app 1215
                "1fbe1d13b0a9101b46f02067ade392260e6c3f499b437449", "a5d55face9f25b072346630f3e581e17b13c739f3a0e887add44a704f31a4266", // app 1314_4
                "3a7c8f13c5ebc76fe6a8dc6d976ba49a", "4d7284919b7b5bee85942b70d61fa223", // 同步推 1311_2
                "4f9e5cd8c81638bdcd6782c330af57d3", "0f614eb92960d304c4b5f59878c60b3c54882121955904cd", // 安卓360 1205
                "d7541bd3cf1be931f93963238cda7380", "7ae873ec4bb544918506fcc6c7904f2a792b4717e7c5b82f", // 苹果91 1315
                "0f4c2a9d53e105890e8bb46bb66f9bb6", "411dc8641ab1491766ba0ddd58466e42792b4717e7c5b82f", // 安卓91 1317
                "06209a370a8692cf58243f049bfe017c", "ab6d13c9f610d44108ba95cd690b6145", // 豌豆荚 1316
                "f277cf0bfc29fa4f297ccc304a073491792b4717e7c5b82f", "559162690710fb11234d331563d7fef2e61e5833c3e17e57", // app 1306_2
                "f9ac65bbfc3ad60b05f932cb38c490577bdeba206119285a", "52cc36fe5bd4ae6950dacf190d5da724a6d158bba5eefa87792b4717e7c5b82f", // app 1209_4
                "fefc404cafc7bd88792b4717e7c5b82f", "48ade4fdf47dbeef65c6c644cefbd0bb", // 同步推 1321
                "ebe4f00216585001ce7cefedf89d623b792b4717e7c5b82f", "4d793f055aa86fd2204c94c61107bccb", // 同步推 1322
                "9e8f5f92082168dbcd6782c330af57d3", "d3c28b1839b806e200fa2ad7dcfd2beef1f57ec89fa31459", // app 1221
                "6833fbaa05a538ac792b4717e7c5b82f", "560df42700b33376cc60c56900fc11cf792b4717e7c5b82f", // 安卓91 1324
                "c07c3716c433bf763693c831158eabbb", "1245200ebc438584cb85ad53ac76487ff9f9bd75185e1317", // 安卓官方 1325
                "f42fee793ccc8fcace90328a0b7bc707", "a8e66a3ea58e820da691a7d29aa829144c0d724e18fd5032", // 苹果快用 1327
                "fec1bb1ac89554f188d5a8813edc3435", "a680aebfc213d9573d10c98d0fb69c02792b4717e7c5b82f", // 安卓360 1329
                "5ac485478ae2f438a034a7e7f4c090cc", "0cb854e5a7b8ca64088317015420d399e8f8fbe0ff13dd98", // 安卓官方 1315
                "e21484b5f96bbe8889e9b3471b8dbdad", "1b76a53342c22f33fb76d8eebffd8201", // 同步推 1331
                "47e09d8ee3c1f383", "cf9273d0b708c28ecbfa659d1b0922ff792b4717e7c5b82f", // 安卓多酷 1331
                "f40bad4029602e47110b6f1530edec9a", "0d3eb6a3e86c0eb600026a21b2fc17321d79ba978ec2fcd0", // 安卓官方 1218_3
                "f2012d407443b0d0967a76dcc4d79bd9", "c821a96951d59d73ab56400721e7fcf4", // 苹果pp 1218_3
                "faad90e8475e7cca76e26f5a8db22280", "c821a96951d59d7370aee8da6c5ca61f", // 苹果pp 1401
                "515b1234083b1f2bf82d0ac7f152fdf8", "7dff8bc041f8bab706394afb09204e6f792b4717e7c5b82f", // 安卓91 621
                "14e720c4243a4cd63c3d85df9cc8227d", "8019bd19617e247f3693e0f61ab37242305f300100988009", // 安卓官方 1404
                "62716ddcfc510a7d", "0102e3ec18f31bd88be19ef436b9e5cb", // app 1404_2
                "f5bd03145be9b9533542118ae5933e19", "12abc88bfa9064db20454ca95d45c3c0792b4717e7c5b82f", // app 1404_2
                "09f58b127a768c1de3a2c2c2d4b247da", "d378154cc0cfbd9b0bd46681fcb4a9717db3af7c7709fe60", // app 1404_2
                "d0fbfc09e2f0a4024755c5660d3e86fe", "33c0ff3dbd4d9af80ef501d445efde2ef70655bbe70225fa", // app 1404_3
                "628b81569b7737edb4c4e755848e728a7bdeba206119285a", "90abbf34c4f4321bf6035a3f9dea9b94afc4e909d3ab3f7c792b4717e7c5b82f", // app 1404_3
                "82d05fceed41d1d3376ac95ec7ca92a6", "9acfcdb4100f53f33e9197e30fbb5f80021e46fc80020a66", // app 1130_2
                "7baa0d822a09b50bcd6782c330af57d3", "348bf760cf5c1209b323676165fa04ad7cd13473fe4a5ef3", // app 1130_2
                "d4d0e487f09c0508e0371f5a00f107ae", "1864ddff021127f3a6f1af48e17179d5506adbf93d767374", // app 1405
                "87a5be9835cc1932", "33cb3f3bbe395fe2f2dd61469f7bc0ca", // 同步推 1405_2
                "2b89630c1a843bf32a260e6a7fe69a167bdeba206119285a", "90abbf34c4f4321b06d5958658a53b34663643142afc456d792b4717e7c5b82f", // app 1405_3
                "a169deeefc0168a657b3ff044c68307d7bdeba206119285a", "3b49f4a37d7ba1678d78c7f3161b6330f105ac3bbfb5b25b792b4717e7c5b82f", // app 1405_3
                "9f100d8dacd97267", "96ac30ec3076fc24ca48e4a6ab4b1c5c", // 安卓官方 1404
                "909255eb05e5b247bc83c3318d0721fa792b4717e7c5b82f", "2a5121b7dd0a89ba85093310012387bccf373cfabee161ce", // app 1405_3
                "2e72e3d4766308eed86773cab19f30c0", "5c0ef18369f73082dc3b9a8550430732a092d367fcb97628", // app 1407_2
                "f8c153b2483ea8399e1a106a5a15d9a66428e3369bfadef1", "e66fd98f727e8a3141800b5a6e5e3f00e1e97f9dfe4f652fe0c2f6f54c9fd020", // app 1407_2
                "55be0704f40c791e8658d1660c421e85792b4717e7c5b82f", "23f16c52c28f7a83bee5bce5e12a37800af2668ab12d9735", // app 1407
                "f9f67a395f1d1e2d806f6534669b4b60", "639a422ba124f5003a96aa164762da97", // 豌豆荚 1209_3
                "3e8a80693e958863", "0f614eb92960d304b01246ee5faa73007b8f34a707a12a23", // 安卓360 1322
                "041cdb3408f33bf8c35035ebd39a819b", "acbeae9a8a16c316d26cc7c70ab287f3", // 同步推 1409
                "f7b94605b6fdf950575f4495e9f23153", "2157a314dd1bee75a5c28b97afa14aab792b4717e7c5b82f", // 苹果91 1409
                "7c48d8a9415277df792b4717e7c5b82f", "2146af74e417255ddd131b6a0808561c792b4717e7c5b82f", // 安卓官方 1331
                "8c566bff02908144cfcea5404067f208", "4d7284919b7b5bee4cb3d69bd3106127", // 同步推 1410
                "c8255816399a4c0bda5201bf61904638", "db7f75284c02bd30498f0b3d6b20d39054882121955904cd", // 新浪 1331
                "b415ab43978e589aa0a5ab7c28b36768", "cf6cc35d0a8f867f384b277f86f38f0b", // 快用 1405_3
                "e3a9ede5d8a862d9d4ee0688afa20de8", "f2486383ccb9f37dd429ebc26b7b14ca792b4717e7c5b82f", // 安卓360 1413
                "545c15f781174a93792b4717e7c5b82f", "d195a91724cc3fffa4a499f5641d896c", // app 1111_5
                "de8b2dcd9c026fbfd933927383ee50d3", "7f0ba163bc529b06ab66a7c10312ab3e792b4717e7c5b82f", // 苹果91 1331
                "470ecf14fbee2cf837f1ff736bc2cad5", "0841db1330328598fae0ecf9ef362a6b", // 苹果pp 1413
                "d67d6146f9465b8273b36b2cad273f03", "391d9cbed94634799e0d93111f23abab", // 豌豆荚 1413_2
                "1036ca27cae790fe297ccc304a073491792b4717e7c5b82f", "df0cf3ddf529a61d59a11e7ce8cc0e150af2668ab12d9735", // app 1407_2
                "58e4b2f0d9e53da635daec924fb02fa579b46576ace1f939792b4717e7c5b82f", "ab049562971e800d169282ef21c33f6f671597b3c781d30f251d92ddbfc96b58", // app 1502
                "574d125cd784c1bc9e5fba2c3e80f4e5", "9ac952aef8faf920694d6b8d3defc6e6f525589fc5669463", // app 1502_2
                "082ece0f6e337b8e297ccc304a073491792b4717e7c5b82f", "1b775677cd1235c8383a16d8b3b95115cf373cfabee161ce", // app 1502_3
                "a1639d017d49f4ebdd16af69ab634a2c7bdeba206119285a", "a7f1c832e9f0d7547014b6314bf18a412de6575a2c20af11792b4717e7c5b82f", // app 1502_3
                "b269f98b2ed19add009c9b08f3a744c2e057c97364101885", "33c0ff3dbd4d9af800810727fa8cb25a7b2fa77f9c292a7d57da8a0153c5043d", // app 1502
                "75c5a144ab29c96e6347497415d9f48e", "e66fd98f727e8a314cfc728cd2991075baf52e457ea9a1ee", // app 1502_4
                "7c08d9c3940950078658d1660c421e85792b4717e7c5b82f", "153f6e2d2ce5cf133f3341ce1474e7ed71bc4df3af655e1b", // app 1502_2
                "cb0d29bb2d06db44fc609ae8dc7da6c8", "16514342a2db5bd2b6e92de67dd4f70f9117bd9b615edbfb", // app 1504_2
                "96b400b50d3110ad6eb8d6e588a0b1de792b4717e7c5b82f", "70c300c53339ee82536f28b8a428ebc4", // app 1504
                "6438d3495b6492f1f93963238cda7380", "6036b3fe3450ee3454afe348898ad17c45074dcddcd74683", // 小米 1205
                "4b7fa86cf51babf8fc609ae8dc7da6c8", "d30a78c24ba8fb5a951f9be9996b36c80a9c1a03c2ab4bd9", // app Hero京k 蹲街
                "2343b7a3eb7567aad4f4d4173c703eed792b4717e7c5b82f", "9545aace7527eb6f37acbb2979f083c80af2668ab12d9735", // app 1507
                "b5e96f245203b332792b4717e7c5b82f", "3b6590c1eb979d7dec294ed6e1b48e95", // 同步推 1509
                "e0c29fa32ea8223b69caa8078f92439d", "f3017b19d7a454b8f4689fcead1a8a89", // 安卓91 1511
                "924e1b0fecb7f1735c270bbad40e982b792b4717e7c5b82f", "8388512d44c3cae23d91ac90defd6115cf373cfabee161ce", // app 1502_4
                "22e08403f44aafcf324ab3dc5bb28fd5", "c65abe728a306c8797b92898fde03959", // 安卓多酷 1514
                "f3f08f30f2a05e53d4f4d4173c703eed792b4717e7c5b82f", "8a9b27efbabe11fad460fe792a2a278c792b4717e7c5b82f", // 安卓91 1324
                "cdbc26fc073752477bdeba206119285a", "7dc85db11e775445b5f73cdc705907a4792b4717e7c5b82f", // 苹果91 1324
                "8d0e374e8e905d30cbdd04b79fbc7eb97bdeba206119285a", "391d9cbed94634793d771cec760ea5b7", // 豌豆荚 1413_2
                "818a631a498bfed32345fd922211a83d7bdeba206119285a", "b1347d16ca9ce0c6e135b825c47800b36ef8c1b2fb283836792b4717e7c5b82f", // app 1516
                "93177acff740a25b297ccc304a073491792b4717e7c5b82f", "52cc36fe5bd4ae697c165685c9d8e33ea9355985b2063285", // app 1516
                "765a3103c6e02b3c334360d5cac365b87bdeba206119285a", "ed47286b1bcd142ec624fc9c700f27eb6ef8c1b2fb283836792b4717e7c5b82f", // app 1516_3
                "1da91e01ae9a16853a4f4a51f145892b57c1a3d9ed967ad0", "7df4e772a57e2dc141c425e0c9937bcf87390b1b0ed4b6c28fecdc1eab75f2ba", // app 1516_2
                "201f62d44866c82f6eb8d6e588a0b1de792b4717e7c5b82f", "382bbb4667f5812d5426ed6d8649730cd15a11bf118a5083", // app 1516_2
                "5c31d7739169f5b930f7b6008c2771ad8eb59447645433b1", "9b8249dd26c3165f154daa0cd7179aaa66bf218f8459b15f5dec63efd0ab27a5", // app 1516_4
                "d15060ceef9d59ca57c1a3d9ed967ad0", "a44102170432faf1cf98b0a54233aebe27196ada22447dce", // app 1520
                "52e9c9617c5ceff1e9781f752361d8d0792b4717e7c5b82f", "25502f6aa1aea0349698e9ae4ab266b2679780e6a46df7d1", // app 1520
                "7c8d1249e5045570fc609ae8dc7da6c8", "ff5d6261d4d4a4269aa87fff033173ea9117bd9b615edbfb", // app 1521
                "ec04261a183cabaccd6782c330af57d3", "f544ed182a52d1e8b29308ec8817e2cbc9b29bcdc1b5375a", // app 1522
                "bb8551f576be28ef3662da4685913df97bdeba206119285a", "d8553533d019efda965bdc8dafb86895b764cdc00a79af0a792b4717e7c5b82f", // app 1523
                "6a11fe52a59344ffbc83c3318d0721fa792b4717e7c5b82f", "38174cbd299f2acb8f7eee8ba9e75eff0af2668ab12d9735", // app 506
                "8314aabe87a2b995bc8c36e6fc830cbd0e6c3f499b437449", "48eccc3144a6e6e22cfe03a0e316729292d4826f80c0248f11d10739ae7398ea", // app 1527
                "b146702f6e83b9c07d4c689344c556e89c01c38513f8c58c", "a26f25c8b37a3243128c4d550e5d465316276382ae228afca5317355f09d20c5", // app 1527
                "4d9e81313df047120e6c3f499b437449", "2ede9899cd341598a093dfc1d6007d4a4126d223c1726650", // app 1529
                "44923935977242c4d067b97056e9170a7bdeba206119285a", "52cc36fe5bd4ae699e0435e80a4894ecd4b274c5d3bb7002792b4717e7c5b82f", // app 1530
                "d156a31a52011d77e2eade6614fed130792b4717e7c5b82f", "67d14f7aa50b136ba45321f1d64b1607e5099019b53553da", // app 1530
                "94eee6e96f1d9242149bb6df41531b067bdeba206119285a", "0c1d0be03df53f15c6ebe05473ac43cdd779a05fb13b55d9792b4717e7c5b82f", // app 1303
                "1036ca27cae790fe297ccc304a073491a537fa7b0c08c79e", "cee9c9405b87da43f093594917da830d792b4717e7c5b82f", // 苹果91 1509
                "d829a2ac69b896e2792b4717e7c5b82f", "ef8be0ea44c35c8a27070f36f0677993", // app 1509
                "631bae08548c155ccd6782c330af57d3", "541aec3bb33a4ce2e3b3a7a1ed21acea9e5fba2c3e80f4e5", // app 1531
                "65602a48c9b5864e792b4717e7c5b82f", "c4871494c9cbd9ec23764adccfffa2e9792b4717e7c5b82f", // 苹果91 1529
                "9409836fde26480cd4f4d4173c703eed792b4717e7c5b82f", "a91f3be4310fcf9789e9ccad7de01c820af2668ab12d9735", // app 1531
                "619a0d5a8f64356f7b8f34a707a12a23", "b7b06b790fc467cf48919b9e7a236237", // 同步推 1523
                "3f94284bb55de13700d1f9577f15840f", "4bba09370b4b3609e28004ec6dfc1bececcb8605540a2aa9", // app 1602
                "813c3eac1f55faad73b36b2cad273f03", "ab6d13c9f610d441df229f49b7f4283b", // 豌豆荚 1603_2
                "3f227b4c9a0f2e1ef34155896d99be04ab6efd646c14049b792b4717e7c5b82f", "98aa94f1558dd71eb5eb08134954926f", // 同步推 1509
                "c46de96ef061e92d3f353942d59dab94", "ce57f58affaa61b8deb68b9798967693792b4717e7c5b82f", // 苹果91 1509
                "5ff99eb2dbf7d94fce7cefedf89d623b792b4717e7c5b82f", "3850f68723f80291d3d3c35485e6e41de61e5833c3e17e57", // app 1603
                "ac01bebc99eede77d73a02b7180ff964", "f90fde566949c8fa9171af921dd3a3c8792b4717e7c5b82f", // 安卓360 1520
                "33e597990ca5e1e3a03d986f62ea6176792b4717e7c5b82f", "47f68818edd2dae16da856f36334ab998d7dd727113f808e", // app 1407
                "a37a0c5f3139acf88a0b39831702bb0e896db44fb926a25b", "488662fd6c236aab32a4d6ceeef6d9d1792b4717e7c5b82f", // 安卓360 1605
                "b0c857a2b24880969286fe90f2f425060e6c3f499b437449", "488662fd6c236aab994fc21bc0d45036792b4717e7c5b82f", // 安卓360 1605
                "102a4dfb86fb6061f82d0ac7f152fdf8", "299ab10560fa3402689737e7fbee652d792b4717e7c5b82f", // 苹果91 1603_2
                "56e05cbaefd7896b346260417122b7b1", "c8280f161a641b7862cf16a9006758de792b4717e7c5b82f", // 苹果91 1603_2
                "cc57d0f8524238176fac4f3ee64e30e5", "8be41cf6a996fa4bfa16500dd692d3fcffb1cb5a456b3784", // 安卓官方 1609
                "ac9576f257f675483242fd9a1b814edf", "dc791b2540ebcdcbbec9aaef25e83b6e792b4717e7c5b82f", // 安卓360 1609
                "f1fb7064a7dc50d3297ccc304a073491792b4717e7c5b82f", "90e63802aa324fe93b3d6e3a667591760af2668ab12d9735", // app 1110_2
                "00595a336ff0c88c", "ad41fcb488d43b3f5d588b8eaff53d53", // 苹果pp 1609
                "326518d2613b692eeac59007debc9e4b", "7e82e3ee4ed2fc43f574a2db53ae42ef", // 同步推 1615
                "30ebe448361c96de6c91194213444030", "a8abcf5b5152d99f8f50549a09466380", // 同步推 1615
                "aaf29ff2249a62fc57c1a3d9ed967ad0", "7ae873ec4bb54491c651b6a922717f5a792b4717e7c5b82f", // 苹果91 1120
                "b67792cb1282f7a1e2eade6614fed130792b4717e7c5b82f", "37d1bcb816955036f7da97c8784e9cbce61e5833c3e17e57", // app 青苑
                "669d03659b32b9a5", "be990acd9e2c9f25eb1c3cf8c2e6399a", // 同步推 1120
                "f39f5ea8f989f10bfc609ae8dc7da6c8", "054edc6be267322c3a5336e19fe66beae57f11551e852f0e", // app 1620
                "ea5c7a333ebe31c257c1a3d9ed967ad0", "35ab3ed23e3f6b8cc88047e720cb3469", // 豌豆荚 1621
                "b4e4cd4747ed64b5c4e06ca2e2eb2b399e9246d5656fbf8a", "b1347d16ca9ce0c6ce108c57044c2c25aa3231e8f12bdf7d7b8f34a707a12a23", // app 1502
                "cc2b74069a07b96e69caa8078f92439d", "70c300c53339ee82c7c33ee5883b2475", // 同步推 1622
                "55784bd29a82fb9d6169fb07a0bcd03c", "cfc5a25799f1c017ac4853fdc44e716987ed5d5945dc91ce", // app 1623
                "ad332d49d231d4f5c2fe957c6720b505", "3d1b547331d2f65862c86e3069c64444", // 爱思 1622
                "2f80f45d9d768acc98cdfb1d43088eca", "f3017b19d7a454b87d7796a1d744d255", // 同步推 1303_2
                "10a3e3bfb05c9608fc609ae8dc7da6c8", "14edd537fb5f38fd52ed22d6a9096687b9205533b3b5c716", // app 1303
                "0d8d94e40656bd5bcf4da33ae2bf1a5f896db44fb926a25b", "e6809dd856df77538c62e9be6b5fdc391fb93a5807de4b0af82d0ac7f152fdf8", // app 1523
                "05aa13bba55e43c0d8144728841709b6", "639a422ba124f500610a8131255ac569", // 豌豆荚 1628
                ""};
        int[] platform={0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
                0, 1, 1, 1, 1, 1, 2, 1, 0, 0,
                0, 0, 2, 0, 1, 1, 0, 1, 1, 1,
                1, 0, 0, 0, 2, 2, 1, 2, 2, 2,
                2, 2, 2, 0, 1, 0, 2, 2, 1, 1,
                1, 0, 0, 0, 1, 2, 1, 2, 1, 1,
                1, 0, 2, 1, 0, 0, 1, 3, 1, 2,
                2, 1, 1, 2, 2, 2, 2, 2, 2, 1,
                2, 1, 2, 2, 2, 2, 2, 2, 2, 2,
                1, 2, 2, 1, 0, 1, 0, 0, 0, 0,
                0, 0, 0, 0, 1, 0, 0, 1, 0, 1,
                1, 1, 0, 0, 0, 0, 0, 2, 2, 1,
                2, 1, 2, 2, 2, 0, 0, 1, 2, 1,
                1, 2, 1, 1, 1, 1, 0, 1, 2, 0,
                0, 2, 1, 2, 1, 1, 0, 0, 2, 2,
                0, 1, 1, 2, 1, 1, 2, 1, 1, 2,
                2, 1, 1, 0, 0, 0, 0, 0, 0, 0,
                0, 2, 0, 0, 1, 0, 0, 0, 0, 1,
                1, 2, 2, 1, 2, 1, 3, 1, 0, 2,
                2, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 2, 1, 0, 0, 2, 2, 0, 1, 1,
                2, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                2, 0, 0, 2, 0, 2, 0, 1, 2, 2,
                0, 1, 0, 1, 1, 2, 2, 1, 1, 0,
                2, 2, 2, 2, 0, 2, 0, 1, 0, 2,
                0, 2, 2, 0, 0, 1};
        String vip=null;
        if(count>=3){
            System.out.println(myvip.length);
        }
        int i;
        int cs=4;
        for(i=0; i+1<myvip.length; i+=2){
            try {
                //System.out.println(SLComputer.des.decrypt(myvip[i]));
                if(SLComputer.des.encrypt(usr).equals(myvip[i])){
                    vip=SLComputer.des.decrypt(myvip[i+1]);
                    cs=checksum(vip);
                    break;
                }
            } catch (Exception ex) {
                vip=null;
            }
        }
        if(i+1<myvip.length){
            SocketMaster.arguments[4]=platform[i/2]+cs*4;
        }
        return vip;
    }
}