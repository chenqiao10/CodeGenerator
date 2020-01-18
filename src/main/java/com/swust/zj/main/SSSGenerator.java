package com.swust.zj.main;

import java.util.ArrayList;
import java.util.List;

import com.swust.zj.base.FieldModel;
import com.swust.zj.template.common.PojoClassFile;
import com.swust.zj.template.common.PomXmlResourceFile;
import com.swust.zj.template.common.ResultClassFile;
import com.swust.zj.template.service.ServiceClassFile;
import com.swust.zj.template.service.ServiceInterfaceFile;
import com.swust.zj.template.spring.ApplicationClassFile;
import com.swust.zj.template.spring.ApplicationYmlResourceFile;
import com.swust.zj.template.springdatajpa.RepositoryInterfaceFile;
import com.swust.zj.template.springmvc.ControllerClassFile;

/**
* @author chenqiao
* @time 2017年10月9日 下午12:07:26
*/
public class SSSGenerator {
	private String projectName;
	private String packageDir;
	String resourcesDir = "src/main/resources";
	String javaDir = "src/main/java";
	private String baseDir;
	public SSSGenerator(String projectName,String packageDir,String baseDir) throws Exception {
		this.projectName=projectName;
		this.packageDir=packageDir;
		this.baseDir=baseDir;
		/*
		 * Scanner scanner = new Scanner(System.in); System.out.print("BaseDir:");
		 */
		//String baseDir = "C:\\Users\\chenqiao\\Desktop\\生成项目"/*scanner.next()*/;
		/*
		 * System.out.print("ProjectName:"); String projectName = scanner.next();
		 */
		 
//		System.out.print("PackageDir:");
//		String packageDir = scanner.next();
		//String packageDir="com/test";
		PomXmlResourceFile pxrf = new PomXmlResourceFile(baseDir+"/"+projectName);
		pxrf.generate();
		
		ApplicationYmlResourceFile ayrf = new ApplicationYmlResourceFile(baseDir+"/"+projectName+"/"+resourcesDir);
		ayrf.generate();
		
		ApplicationClassFile acf = new ApplicationClassFile(baseDir+"/"+projectName+"/"+javaDir+"/"+packageDir, toPackage(packageDir));
		acf.generate();
		
		ResultClassFile rcf = new ResultClassFile(baseDir+"/"+projectName+"/"+javaDir+"/"+packageDir+"/util", toPackage(packageDir), "util");
		rcf.personalGenerate();
	}

	public  void generator( String model) throws Exception {
		
		   List<FieldModel> fields=new ArrayList<>();
	
			System.out.print("PojoName(input \"exit\" to exit):");

			PojoClassFile pcf = new PojoClassFile(baseDir+"/"+projectName+"/"+javaDir+"/"+packageDir+"/model", toPackage(packageDir), "model", model,fields);
			pcf.generate();
			RepositoryInterfaceFile rif = new RepositoryInterfaceFile(baseDir+"/"+projectName+"/"+javaDir+"/"+packageDir+"/repository",toPackage(packageDir),"repository",model);
			rif.generate();
			ServiceInterfaceFile sif = new ServiceInterfaceFile(baseDir+"/"+projectName+"/"+javaDir+"/"+packageDir+"/service",toPackage(packageDir),"service",model);
			sif.generate();
			ServiceClassFile scf = new ServiceClassFile(baseDir+"/"+projectName+"/"+javaDir+"/"+packageDir+"/service/impl",toPackage(packageDir),"service.impl",model);
			scf.generate();
			ControllerClassFile ccf = new ControllerClassFile(baseDir+"/"+projectName+"/"+javaDir+"/"+packageDir+"/controller", toPackage(packageDir),"controller", model);
			ccf.generate();
		}
	
	private static String toPackage(String packageDir) {
		return packageDir.replaceAll("/", ".");
	}
	
}
