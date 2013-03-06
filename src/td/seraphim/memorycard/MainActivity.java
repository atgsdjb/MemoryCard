package td.seraphim.memorycard;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import td.seraphim.base.SeraphListAdapter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
 
public class MainActivity extends Activity {

	protected static final String TAG = "com.seraphim.memory_card";
	private ListView listView;
	private BaseAdapter  adapter = null;
	private ProgressDialog dialog;
	private List<DictItem> data;
	private InputStream in;
	
	private AsyncTask<Integer,Integer,Integer> readerTask  = new AsyncTask<Integer, Integer, Integer>(){
		
		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			try{
				if(data==null){
					data = new ArrayList<MainActivity.DictItem>();
				}else{
					data.clear();
				}
				Reader reader = new InputStreamReader(in);
				BufferedReader r = new BufferedReader(reader);
				int i = 0;
				String str = r.readLine();
				while(str!=null){
				
//					String[]  l_a = str.split("\t");
					DictItem  item = new DictItem(str);
					data.add(item);
					str = r.readLine();
				}
				
				
			}catch(Exception e){
				
			}
			return null;
		}

		@Override
		protected void onPostExecute(Integer result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			adapter =new SeraphListAdapter<DictItem>(MainActivity.this, data);
			listView.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			
		}
		
		
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);  
		 listView = new ListView(this);
		setContentView(listView);  
		ArrayList<String> list = new ArrayList<String>();
		list.add("seraphim");
		list.add("td_atgs");
		
		in  = getResources().openRawResource(R.raw.d1_100);
		readerTask.execute(12);
	}
	
	
	
	
	static private class DictItem{
		static int g_id=0;
		int id ;
		String item1;
		String item2;
		public DictItem(String _item1,String _item2){
			item1 = _item1;
			item2 = _item2;
			id = g_id++;
		}
		public DictItem(String str) {
			// TODO Auto-generated constructor stub
			String[] l_strs= str.split("\t");
			item1 = l_strs[0];
			item2 = l_strs[1];
			id = ++g_id;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			sb.append(id);
			sb.append(":");
			sb.append(item1);
			sb.append("\t");
			sb.append(item2);
			return sb.toString();
		}
		
	}

	

}
