# CH 4 클라우드_아키텍처 설계 & 배포

### LV 0 - 요금 폭탄 방지 AWS Budget 설정

- 설정 완료된 AWS Budgets 화면을 캡처하여 README.md에 첨부하세요.

<p align="center">
  <img src="docs/images/LV0_Budget설정.png" width="100%">
</p>

### LV 1 - 네트워크 구축 및 핵심 기능 배포

- 설정 완료된 EC2의 퍼블릭 IP 를 README.md에 첨부하세요.

<p align="center">
  <img src="docs/images/LV1_EC2퍼블릭IP.png" width="100%">
</p>

- 추가로 EC2에 배포한 이후 Health Check 한 결과도 첨부했습니다.

<p align="center">
  <img src="docs/images/LV1_EC2_healthcheck.png" width="100%">
</p>

### LV 2 - DB 분리 및 보안 연결하기

1. **Actuator Info 엔드포인트 URL**
    - `/actuator/info`에 접속했을 때, Parameter Store에 저장했던 또는 확인용 파라미터 값이 JSON으로 출력되는 URL을 README.md에 작성하세요
    - *(예: `http://3.34.xx.xx:8080/actuator/info`)*

<p align="center">
  <img src="docs/images/LV2_teamname_출력.png" width="100%">
</p>

2. **RDS 보안 그룹 스크린샷**
    - AWS 콘솔 > RDS > 보안 그룹 > **[인바운드 규칙]** 탭을 캡처하세요.
    - 소스(Source) 부분에 IP 주소(`0.0.0.0/0`)가 아닌, EC2의 보안 그룹 ID (`sg-xxxxx`)가 등록되어 있음을 보여주어야 합니다.

<p align="center">
  <img src="docs/images/LV2_보안그룹_확인.png" width="100%">
</p>

### LV 3 - 프로필 사진 기능 추가와 권한 관리

- 발급받은 Presigned URL 1개와 해당 URL의 만료 시간을 README.md에 기재하세요.

<p align="center">
  <img src="docs/images/LV3_get_file_url.png" width="100%">
</p>

```json
{
   "url": "https://cloud-project-sohyun-files.s3.ap-northeast-2.amazonaws.com/uploads/9af7b150-0a1f-4f15-a17d-bc49e92b64d1_%EB%B6%84%ED%99%8D%EA%BD%83_%EC%9D%BC%EB%9F%AC%EC%8A%A4%ED%8A%B8.png?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEI3%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaDmFwLW5vcnRoZWFzdC0yIkgwRgIhAJ2QjMGgEG2NtluJAK9Mj7NqzFvz7DsE6MXRimE19tJLAiEA0bo8a%2BfFqZprNBaOHFLZ41%2BU0d3GW3H7m3vXSxI5J94qyQUIVxAAGgw1OTQwNzkxMzM5ODciDIjV3Jef1Str3FUY8SqmBXrRXIYNxsHrXNb9d%2FqvLa6ae738jGnQTzRC16nQBc45Ttm9Jm1d9GgcWslnulsvgPeis3D6bA4mjpesou%2FN7YnpHkkKLZzcBl%2FecaVBPbjlu5sUpPmXddQUSRY1EMprQBVB%2Bu1hLhldRuiWBjiCMXKjt26mDDTYd9aRNcFdrvhjrSzsvTC7XylF8toIFZp6fv2hMJPvCCebr9UNRYGk9ERT92ZAk57acHgpRs51d%2FAJHBVyOH47OqR9OfTnLBdkAzmOzJP9xOjuPCEXNFxyoqx%2BF4PQRtYA1Ze6fyCLcXarBGiNEnHBPoexqktMSVc85Fw8C5HigR7I6qkbl7i4XPDIYEI6B3wpZ6Isxjxq7c1IwaOiyOM9rpSJivuRWWVBFO6w8m0tOTMP7dUO%2B1jkStjK3bVQ5JUGHm%2Bhg6rxe%2BUZvm%2FVxCvk1QPQ0w82jiEdwftPF%2B5aU648w9tArNpx%2Fkyzc%2B5ReiqPcbYX4Los7YTde6g1Jw0zaxhlkX6sR9Bib7XOctF0zaADi9gPG%2FGec77Gfy5vFGehkQ6jeG3z7aOJUQYozCKsd7sAeTbAUADCFIQPVzEapTJAzvO%2B15L0IGolGGqCOL98cqn66b859bnckAA88Yk6ijhXDY%2BzOvFQArSxc%2B8ZfYUDkNicB5%2F3xkceDng9s%2F0BtDa2ZSl3B2%2BfzlmCkm20N0Z8fmuzNOy%2Bfs0mYfIexF8PXp4KtR0wKV%2FWFXNTu3liAVTJhr6IWKbRKXJdOsfBUlDIJFfzv%2F4K4Ai%2B0rM3VP6NZUh7BJ7w0lDoN5WtG7UXX2rH2M8B5QOVSvPJx%2FfNwS93E8sUdhY1oBOxhJcp%2Bz9p%2FwtJY%2FPSHg1U7j42pgFg%2B98EgEnzmN26EQj%2BSm8Y4Wu0t7DNAC2KS8u68u1M5DCd%2BcPNBjqwAQWS73xArjQqUR6EMS8B9iWT7M%2BM0hjdOB4AYuNPdWNIt3XiihfYc%2FpXWYnn6m%2BgtjPxi8SPUMaB67%2FNYIfiRCreBuED5qO4nk8hqkdFcSaZD7OkPJSVIHZc44TXR3407miY6rm4So2eD%2BhztXY0q0GSqan5QZFEF20%2FUbXIPrIPySY2knY1t1en5IyKIWuPE2ESM4aUpyFGvTUYj%2BKsRyWC7urviB1ZBtyvsgpHM%2B2P&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260311T054405Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIAYUUPAGERTKWWQN5G%2F20260311%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=24b7ff08fe61e4b61596cf462f3b91ba121b741a39c0ddcb8fe4f3a0e4bce3f5",
   "expirationTime": "2026-03-18T05:44:05.798151438Z"
}
```

### LV 4 - Docker & CI/CD 파이프라인 구축

1. **Github Actions 성공 이미지**
   - Github Repository > Actions 탭에서 배포 워크플로우가 초록색 체크(Success)로 표시된 화면을 캡처 후 README.md에 올려 주세요

<p align="center">
  <img src="docs/images/LV4_Github_Actions.png" width="100%">
</p>

2. **EC2 터미널 이미지**
   - EC2에 접속하여 `sudo docker ps` 명령어를 입력했을 때, 실행 중인 컨테이너 목록이 나오는 화면을 캡처 후 README.md에 올려 주세요

<p align="center">
  <img src="docs/images/" width="100%">
</p>













