# USE 使用

	<dependency>
		<groupId>org.mountcloud</groupId>
		<artifactId>imagej-operate</artifactId>
		<version>0.1</version>
	</dependency>

# English

## Description
&nbsp;&nbsp;This project is the operation basic framework of imagej, mainly to optimize the operation of imagej. This project is mainly the operation of java background image.

## Instructions
1: Please refer to IJGaussianBlurParam and IJGaussianBlurOperation.

2: A complete operation is done by Param and Operation.

3: Operation extends IJOperationBase, param extends IJParamBase, expands the operation as above.


# 中文

## 描述

&nbsp;&nbsp;此项目是imagej的操作基础框架，主要是为了优化imagej的操作，此项目主要是java后台对图像的操作。

## 特点

1：请参考IJGaussianBlurParam与IJGaussianBlurOperation。

2：一个完整的操作是Param与Operation配合完成。

3：operation继承IJOperationBase，param继承IJParamBase，按照以上方式扩展操作。


# Demo 用例


    @Test
    public void testBlur() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        IJGaussianBlurParam param = new IJGaussianBlurParam();
        param.setRadius(25);
        param.setSourceImage("D:\\Pictures\\222.jpg");
        param.setTargetImage("D:\\Pictures\\222_25.png");


        IJGaussianBlurOperation operation = IJOperationFactory.getFactory("org.mountcloud.imagej.operate.operation").createOperation(param);
        System.out.println(operation.run());
    }

## note 笔记

Subsequent releases are expected to extend rich image operations and upgrade the underlying framework.

后续版本预计会扩展丰富的图像操作，并且升级基础框架。