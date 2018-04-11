package test01;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class CunstomRequest implements JavaSamplerClient{
	private static final String URLNAME="URL";
	private static final String DEFAULTURL="http://www.taobao.com/";
	private String inputUrl;
	//初始化方法
	public void setupTest(JavaSamplerContext context) {
		this.inputUrl=context.getParameter(this.URLNAME, this.DEFAULTURL);
		System.out.println("你访问的是"+inputUrl);
		// TODO Auto-generated method stub
		
	}
	private String resultData;

	public SampleResult runTest(JavaSamplerContext context) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url =new URL(this.inputUrl);
			URLConnection con=url.openConnection();
			InputStream is=con.getInputStream();
			byte[] buffer = new byte[1024];
			int len;
			
			while((len=is.read(buffer))!=-1){
				String data = new String(buffer,"UTF-8");
				sb.append(data);
			}
			System.out.println(sb.toString());
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hello-runTest");
		resultData="这是响应结果"+sb.toString();
		SampleResult result=new SampleResult();
		result.setSuccessful(true);
		result.setSampleLabel("修改了名称");
		result.setResponseData(resultData,null);
		result.setDataType(SampleResult.TEXT);
		return result;
	}

	public void teardownTest(JavaSamplerContext context) {
		// TODO Auto-generated method stub
		System.out.println("Hello-teardownTest");
		
	}
  //自定义参数
	public Arguments getDefaultParameters() {
		// TODO Auto-generated method stub
		System.out.println("getDefaultParameters");
		Arguments arguments =new Arguments();
		arguments.addArgument(this.URLNAME, this.DEFAULTURL);
		return arguments;
	}
}
