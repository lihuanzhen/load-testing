package soft.lhz;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JavaRequestDemo implements JavaSamplerClient {

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
		// TODO Auto-generated method stub
//		URL
		System.out.println("Hello-runTest");
		resultData="这是响应结果";
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
