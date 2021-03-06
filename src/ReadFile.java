

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//저장된 파일에서 주문내역을 읽을때 사용되는 클래스
public class ReadFile{
	FileReader fr;
	String orderList="";
	String filePath;
	String sendMsg="";

	public void getOrderListToFile(CafeServerHandler csh,String readDate){
		try{
			String readFilePath;
			readFilePath = "c:/java/"+readDate+".txt";
			File readFile = new File(readFilePath);
			if(!readFile.exists()){
				csh.sendOrderList("*정보가없습니다.");
			}
			else{
				BufferedReader in = new BufferedReader(new FileReader(readFilePath));
				String s;
				
				while ((s = in.readLine()) != null) {
					System.out.println("주문목록 인덱스++"+s);
					sendMsg += s;
					sendMsg += "[EOOL]";
					//_ol.indexTokenizer(s);
				}
				sendMsg+="END[EOOL]";
				csh.sendOrderList(sendMsg);
				in.close();
			}
			
		}catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	    }
	}
	public int getIndexNum(String _filePath){
		int indexNum=1;
		try{
			BufferedReader in = new BufferedReader(new FileReader(_filePath));	
			while ((in.readLine()) != null) {
				indexNum++;
			}
			in.close();
		}catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
	    }
		return indexNum;
	}
	public void setFileDatePath(NowTime _nt){
		filePath = "c:/java/";
		filePath +=_nt.getSaveDate()+".txt";
	}
}

