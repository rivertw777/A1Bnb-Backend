<div align="center">
<img src="https://a1bnb-project.s3.ap-northeast-2.amazonaws.com/%EB%8C%80%EB%AC%B83.png" width="800px" height="270px"/></a>
</div>
<br>

# 🖥 A1BnB Renewal 
<br>
<div align="center">
<b>A1BnB는 AI 기반 숙박 공유 서비스입니다.<br>
<b>Object Detection, Classification 모델을 활용하여 호스트가 사진을 업로드하면<br>
<b>어떤 공간인지, 어떤 어매니티가 있는지 분석하여 게시물 작성을 도와주는 서비스 입니다.<br>
</div>
<br>
<br>

## 🛠️&nbsp;&nbsp;&nbsp;링크&nbsp;&nbsp;&nbsp;
<br>
<div align="center">
<table border=""4>

  <tr>
    <td rowspan="1" align="center"><b>배포 링크</td>
    <td>https://a1bnb.site</td>
  </tr>

  <tr>
    <td rowspan="1" align="center"><b>Frontend Repo</td>
    <td>https://github.com/rivertw777/A1BnB-Frontend</td>
  </tr>
	    
  <tr>
    <td rowspan="2" align="center"><b>Deep Learning API Repo</td>
    <td>https://github.com/rivertw777/A1BnB-Classification</td>
  </tr>
  <tr>
      <td>https://github.com/rivertw777/A1BnB-Detection</td>
  </tr>
	    
  <tr>
    <td rowspan="1" align="center"><b>구현 기능</td>
    <td>https://a1bnb-renewal-api.gitbook.io/a1bnb-implementation-features-1/</td>
  </tr>

  <tr>
    <td rowspan="1" align="center"><b>API 명세</td>
    <td>https://a1bnb-renewal-api.gitbook.io/a1bnb-api-reference</td>
  </tr>

  <tr>
    <td rowspan="2" align="center"><b>개발 일지</td>
    <td>
      <a href="https://velog.io/@nickygod/series/SpringReact-AI-%EB%93%B1%EB%A1%9D-%EC%9B%B9%EC%84%9C%EB%B9%84%EC%8A%A4">A1BnB</a>  
    </td>
  </tr>
	    
  <tr>
    <td>
      <a href="https://velog.io/@nickygod/series/Spring-Security-JWT-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-with-Redis">Spring Security + JWT</a>
    </td>
  </tr>
  
</table>
</div>
<br>
<br>

## 🛠️&nbsp;&nbsp;&nbsp;Project Architecture&nbsp;&nbsp;&nbsp;
<br>
<div align="center">
<img src="https://a1bnb-project.s3.ap-northeast-2.amazonaws.com/%ED%94%8C%EC%A0%9D+%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98.png" width="83.7%"/></a>
</div>
<br>
<br>

## 🛠️&nbsp;&nbsp;&nbsp;ERD&nbsp;&nbsp;&nbsp;
<br>
<div align="center">
<img src="https://a1bnb-project.s3.ap-northeast-2.amazonaws.com/a1bnb+erd.png" width="100%"/></a>
</div>
<br>
<br>

## 🛠️&nbsp;&nbsp;&nbsp;Tech Stacks&nbsp;&nbsp;&nbsp;
<br>
<div align="center">
<table border=""4>
  
  <tr>
    <td rowspan="1" align="center"><b>BE</td>
    <td><img src="https://user-images.githubusercontent.com/112257466/209075280-78be8487-7d6a-485c-92a8-d6677f0caab9.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>Spring Boot</td>
  </tr>

  <tr>
    <td rowspan="1" align="center"><b>FE</td>
    <td><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/2300px-React-icon.svg.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>React.js</td>
  </tr>

  <tr>
    <td rowspan="2" align="center"><b>DB</td>
    <td><img src="https://user-images.githubusercontent.com/112257466/209078356-d9120e3d-9498-4ee4-a38d-139a263910f4.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>MySQL</td>
  </tr>
  <tr>
    <td><img src="https://p7.hiclipart.com/preview/282/358/343/redis-database-erlang-cache-computer-servers-others-thumbnail.jpg" width="15px" alt="_icon" />&nbsp;&nbsp;<b>Redis</td>
  </tr>
  
  <tr>
    <td rowspan="6" align="center"><b>Infra</td>
    <td><img src="https://static-00.iconduck.com/assets.00/aws-ec2-icon-423x512-iaajemnx.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>AWS EC2</td>
  </tr>
  <tr>
    <td><img src="https://seeklogo.com/images/A/aws-rds-relational-database-service-logo-99EA3E8EA4-seeklogo.com.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>AWS RDS</td>
  </tr>
  <tr>
    <td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZn-0RTwQV0Aqu6kDoqEgYD2bIrdoSP5OLhhZQHNB0GA&s" width="15px" alt="_icon" />&nbsp;&nbsp;<b>AWS ElastiCache</td>
  </tr>
  <tr>
    <td><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Amazon-S3-Logo.svg/1200px-Amazon-S3-Logo.svg.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>AWS S3</td>
  </tr>
  <tr>
    <td><img src="https://www.tsmean.com/assets/img/the-ultimate-aws-lambda-tutorial-for-nodejs/aws-lambda-logo.svg" width="15px" alt="_icon" />&nbsp;&nbsp;<b>AWS Lambda</td>
  </tr>
  <tr>
    <td><img src="https://iconape.com/wp-content/files/kz/370585/svg/aws-api-gateway-logo-icon-png-svg.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>AWS Api Gateway</td>
  </tr>
	    
  <tr>
  <td rowspan="3" align="center"><b>CI/CD</td>
      <td><img src="https://www.svgrepo.com/show/353659/docker-icon.svg" width="15px" alt="_icon" />&nbsp;&nbsp;<b>Docker</td>
  </tr>
  <tr>
      <td><img src="https://cdn.icon-icons.com/icons2/2699/PNG/512/jenkins_logo_icon_170552.png" width="15px" alt="_icon" />&nbsp;&nbsp;<b>Jenkins</td>
  </tr>
  <tr>
      <td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFrK09IvHpZZXR7UwT4C9F-lSA9BOXh0-QmXx7aZ3Ngw&s" width="15px" alt="_icon" />&nbsp;&nbsp;<b>Ngrok</td>
  </tr>
</table>
</div>
