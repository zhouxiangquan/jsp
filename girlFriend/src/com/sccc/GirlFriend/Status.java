package kwx;

import java.util.ArrayList;
import java.util.HashMap;

public class Status {
	
	private ArrayList<string> zhuangTai;//�����������״̬
	private HashMap<String, ArrayList<String>> tiMu; //�����������״̬��ѡ��
	
	
	public Status() {
		//��ʼ��ֵ
		zhuangTai = new ArrayList<String>();
	    tiMu = HashMap<String, ArrayList<String>>();
	    
	    //������
	    String qingKuang = "û�нӵ�Ů���ѵ绰";
	    zhuangTai.add(qingKuang);
	    
	    //ѡ�����
	    String xuanXiang1 = "���ֻ�������";
	    String xuanXiang2 = "���ڴ���Ϸ";
	    String xuanXiang3 = "���ڸ�������";
	    String xuanXiang4 = "���ڹ���";
	    
	    ArrayList<String> temp = new ArrayList<String>();
	    //�����м����
	    temp.add(xuanXiang1);
	    temp.add(xuanXiang2);
	    temp.add(xuanXiang3);
	    temp.add(xuanXiang4);
	    
	    //�������ѡ�����hash��
	    tiMu.put(qingKuang, temp);			
	}
	
	public ArrayList<String> getZhuangTai(){
		return zhuangTai;
	}
	
	public void setZhuangTai(ArrayList<String> zhuangTai){
		this.zhuangTai = zhuangTai;	
	}
	public HashMap<String, ArrayList<String>> getTiMu(){
		return tiMu;
	}
	

}
