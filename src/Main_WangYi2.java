import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Channels {

	public List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();

	public void putData(String cid, String name, String ctype) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("cid", cid);
		dataMap.put("name", name);
		dataMap.put("ctype", ctype);
		datas.add(dataMap);
	}

	public List<Object> getCtypeByCid(Object cid) {
		List<Object> returnDateList = new ArrayList<>();
		if (cid == null) {
			return returnDateList;
		}
		for (Map<String, Object> map : datas) {
			if (map.get("cid").toString().equals(cid.toString()))
				returnDateList.add(map.get("ctype"));
		}
		return returnDateList;
	}

	public List<Map<String, Object>> getDatas() {
		return datas;
	}

}

class Players {

	private List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();

	public void putData(String pid, String name, String cid) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("pid", pid);
		dataMap.put("name", name);
		dataMap.put("cid", cid);
		datas.add(dataMap);
	}

	public List<Map<String, Object>> getDatas() {
		return datas;
	}

}

class Prepaid {

	private List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();

	public void putData(String id, String pid, String cash) {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("id", id);
		dataMap.put("pid", pid);
		dataMap.put("cash", cash);
		datas.add(dataMap);
	}

	public List<Object> getCashByPid(Object pid) {
		List<Object> returnDateList = new ArrayList<>();
		if (pid == null) {
			return returnDateList;
		}
		for (Map<String, Object> map : datas) {
			if (map.get("pid").toString().equals(pid.toString()))
				returnDateList.add(map.get("cash"));
		}
		return returnDateList;
	}

	public List<Map<String, Object>> getDatas() {
		return datas;
	}

}

class Result implements Comparable<Result> {

	private Set<Integer> pcnt = new HashSet();
	private int cash;
	private Integer ctype;

	public Result(Integer ctype, Integer pid, int cash) {
		this.ctype = ctype;
		this.pcnt.add(pid);
		this.cash = cash;
	}

	public void update(Result resultT) {
		this.pcnt.addAll(resultT.getPcnt());
		this.cash += resultT.cash;
		this.ctype = resultT.ctype;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public Set<Integer> getPcnt() {
		return pcnt;
	}

	public void setPcnt(Set<Integer> pcnt) {
		this.pcnt = pcnt;
	}

	public Integer getCtype() {
		return ctype;
	}

	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}

	@Override
	public int compareTo(Result o2) {
		int condition = this.getCash() - o2.getCash();
		if (condition != 0) {
			return condition * -1;
		} else {
			return this.ctype - o2.ctype;
		}
	}
}

public class Main_WangYi2 {

	public static void main(String[] args) {

		Channels channels = new Channels();
		Players players = new Players();
		Prepaid prepaids = new Prepaid();

		Scanner sc = new Scanner(System.in);
		for (int j = 0; j < 3; j++) {
			String tableInfo = sc.nextLine();
			String[] inputArray = tableInfo.split(" ");
			int dataCount = Integer.valueOf(inputArray[1]);
			if (inputArray[0].equalsIgnoreCase("channels")) {
				String heads = sc.nextLine();
				String[] headsArray = heads.split(" ");
				HashMap<String, Integer> map = new HashMap<>();
				for (int i = 0; i < headsArray.length; i++) {
					map.put(headsArray[i], i);
				}
				for (int i = 0; i < dataCount; i++) {
					String value = sc.nextLine();
					String[] valueArray = value.split(" ");
					channels.putData(valueArray[map.get("cid")], valueArray[map.get("name")], valueArray[map.get("ctype")]);
				}
			}
			if (inputArray[0].equalsIgnoreCase("players")) {
				String heads = sc.nextLine();
				String[] headsArray = heads.split(" ");
				HashMap<String, Integer> map = new HashMap<>();
				for (int i = 0; i < headsArray.length; i++) {
					map.put(headsArray[i], i);
				}
				for (int i = 0; i < dataCount; i++) {
					String value = sc.nextLine();
					String[] valueArray = value.split(" ");
					players.putData(valueArray[map.get("pid")], valueArray[map.get("name")], valueArray[map.get("cid")]);
				}
			}
			if (inputArray[0].equalsIgnoreCase("prepaids")) {
				String heads = sc.nextLine();
				String[] headsArray = heads.split(" ");
				HashMap<String, Integer> map = new HashMap<>();
				for (int i = 0; i < headsArray.length; i++) {
					map.put(headsArray[i], i);
				}
				for (int i = 0; i < dataCount; i++) {
					String value = sc.nextLine();
					String[] valueArray = value.split(" ");
					prepaids.putData(valueArray[map.get("id")], valueArray[map.get("pid")], valueArray[map.get("cash")]);
				}
			}
		}

		List<Map<String, Object>> playerDatas = players.getDatas();
		List<Map<String, Object>> resultDatas = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> rows : playerDatas) {
			Object cid = rows.get("cid");
			List<Object> ctypeList = channels.getCtypeByCid(cid);
			if (ctypeList.isEmpty()) {
				Map<String, Object> m = new HashMap<>();
				m.put("pid", rows.get("pid"));
				m.put("ctype", "-1");
				resultDatas.add(m);
			}
			for (Object object : ctypeList) {
				Map<String, Object> m = new HashMap<>();
				m.put("pid", rows.get("pid"));
				m.put("ctype", object);
				resultDatas.add(m);
			}
		}
		List<Map<String, Object>> resultDatas2 = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> rows : resultDatas) {
			Object pid = rows.get("pid");
			List<Object> cashList = prepaids.getCashByPid(pid);
			if (cashList.isEmpty()) {
				Map<String, Object> m = new HashMap<>();
				m.put("ctype", rows.get("ctype"));
				m.put("pid", rows.get("pid"));
				m.put("cash", "0");
				resultDatas2.add(m);
			}
			for (Object object : cashList) {
				Map<String, Object> m = new HashMap<>();
				m.put("ctype", rows.get("ctype"));
				m.put("pid", rows.get("pid"));
				m.put("cash", object == null ? "0" : object);
				resultDatas2.add(m);
			}
		}

		Map<String, Result> resultMap = new HashMap<String, Result>();

		for (Map<String, Object> rows : resultDatas2) {
			Integer ctype = Integer.valueOf(rows.get("ctype").toString());
			Integer pid = Integer.valueOf(rows.get("pid").toString());
			Integer cash = Integer.valueOf(rows.get("cash").toString());
			Result resultT = new Result(ctype, pid, cash);
			Result result = resultMap.put(ctype.toString(), resultT);
			if (result != null) {
				resultT.update(result);
			}
		}
		List<Result> resultList = new ArrayList<>(resultMap.values());

		Collections.sort(resultList);

		for (Result result : resultList) {
			System.out.print(result.getCtype());
			System.out.print(" ");
			System.out.print(result.getPcnt().size());
			System.out.print(" ");
			System.out.print(result.getCash());
			System.out.println();
		}

	}
}
