import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VowelSpellchecker {


  public String[] spellchecker(String[] wordlist, String[] queries) {
    HashMap<String, List<String>> lowerMapper = new HashMap<>();
    HashMap<String, List<String>> vowelMapper = new HashMap<>();
    Set<String> words = new HashSet<>(Arrays.stream(wordlist).toList());

    for (String word : wordlist) {
      String toLower = word.toLowerCase();
      if (!lowerMapper.containsKey(toLower)) {
        lowerMapper.put(toLower, new ArrayList<>());
      }
      lowerMapper.get(toLower).add(word);
      String nonVowelVersion = toLower.replaceAll("[aeiouAEIOU]", "_");
      if (!vowelMapper.containsKey(nonVowelVersion)) {
        vowelMapper.put(nonVowelVersion, new ArrayList<>());
      }
      vowelMapper.get(nonVowelVersion).add(word);
    }

    ArrayList<String> result = new ArrayList<>();
    for (String query : queries) {
      String value = "";
      if (words.contains(query)) {
        value = query;
      } else {
        String lower = query.toLowerCase();
        String vowel = lower.replaceAll("[aeiouAEIOU]", "_");
        if (lowerMapper.containsKey(lower)) {
          value = lowerMapper.get(lower).getFirst();
        }
        if (value.equals("") && vowelMapper.containsKey(vowel)) {
          value = vowelMapper.get(vowel).getFirst();
        }
      }
      result.add(value);
    }
    return result.toArray(new String[0]);
  }

  void main() {
    String[] wordList = {"dtk", "oag", "pad", "nfs", "xej", "bys", "dgp", "hev", "hsk", "gws", "kqd", "ztv", "fvi",
        "irw", "rhv", "dys", "ofl", "lnt", "vmq", "vsp", "kbv", "fof", "ako", "gbu", "mbd", "szy", "zlr", "cpt", "xck",
        "hdg", "uoo", "fvm", "vla", "fpe", "mpk", "abv", "mcf", "ibp", "num", "ouv", "icx", "uab", "wka", "ozz", "gte",
        "vpv", "rvd", "hed", "fcl", "iaf", "sba", "wxa", "gjp", "qzh", "kjv", "fxr", "msf", "bwj", "wqp", "whj", "vxu",
        "xoe", "wwh", "ray", "jor", "vsi", "yft", "ngn", "inf", "ggw", "kwj", "irk", "vqs", "zvi", "lwx", "ooc", "fdi",
        "ana", "jcg", "rga", "vow", "gia", "nxa", "pgr", "ymw", "kfk", "rur", "bud", "cfe", "ffn", "wnr", "uzh", "yff",
        "ucx", "xss", "mbi", "tph", "efn", "syu", "sqz"};
    String[] queries = {"nrm", "szv", "inf", "ngn", "Ouv", "mqk", "bra", "pie", "xyz", "mif", "hjz", "hlr", "ltt",
        "zce", "dtK", "lyw", "zvi", "yha", "bMi", "eyy", "xoc", "MCF", "vOW", "tvv", "wpv", "jcg", "kqd", "hvi", "wmz",
        "nmf", "aiF", "fvm", "puk", "vxi", "ztv", "NxA", "rwo", "kFK", "vxu", "esi", "vla", "uub", "fom", "gJp", "ahb",
        "bJW", "ipv", "syU", "nyg", "xss", "iom", "qnp", "soy", "smv", "zzo", "Bys", "lnt", "wuc", "uqk", "syu", "aok",
        "efn", "dju", "ooe", "ipu", "VSi", "bod", "hdg", "wux", "vex", "qee", "ueq", "rhv", "czm", "yff", "npo", "wka",
        "vmm", "jtk", "gto", "rjx", "gjp", "nza", "idj", "xuf", "yzp", "nhc", "kjv", "hdG", "xOE", "whj", "eox", "lcv",
        "Mbd", "bud", "vxe", "dgp", "smo", "qdv", "bav"};
    System.out.println(Arrays.toString(spellchecker(wordList, queries)));
  }
}
