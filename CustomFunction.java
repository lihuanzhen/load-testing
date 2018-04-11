package test02.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

public class CustomFunction extends AbstractFunction{

	private Object[] values;
	private CompoundVariable f,s;
	//参数描述
	public List<String> getArgumentDesc() {
		// TODO Auto-generated method stub
		System.out.println("getArgumentDesc");
		List des=new ArrayList();
		des.add("num1");
		des.add("num2");
		return des;
	}

	//执行方法
	@Override
	public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
		// TODO Auto-generated method stub
		System.out.println("execute");
		f=(CompoundVariable)this.values[0];
		s=(CompoundVariable)this.values[1];
		int sum=new Integer(f.execute().trim())+new Integer(s.execute().trim());
		return String.valueOf(sum);
	}

	//设置函数参数
	@Override
	public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
		System.out.println("setParameters");
		checkParameterCount(parameters,2);
		this.values=parameters.toArray();
		
	}

	//设置函数名称
	@Override
	public String getReferenceKey() {
		System.out.println("getReferenceKey");
		return "__AAA";
	}

}
