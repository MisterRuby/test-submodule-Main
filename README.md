# [Git] Git Submodule 사용
지금 근무 하고 있는 회사에 입사 했을 때 팀이 맡고 있던 프로젝트 A 는 다른 프로젝트 B 를 서브 모듈로 사용하는 구조였습니다.
서브 모듈을 활용한 구조는 처음이어서 어떤 장점이 있는지 궁금했습니다.

---

## Submodule 이란?
Git Submodule은 저장소 안에 **독립적인 버전 관리가 가능한 프로젝트**를 포함하는 기능입니다. 이를 활용하면 여러 프로젝트에서 공동으로 사용하는 코드베이스를 효율적으로 관리할 수 있습니다.

- **독립적 버전 관리**: 서브모듈은 별개의 커밋과 히스토리를 유지합니다.
- **재사용 가능한 코드**: 여러 프로젝트에서 공통 코드를 재활용할 수 있습니다.
- **경량 디렉토리**: 원본 히스토리를 포함하지 않아 메인 프로젝트와 분리됩니다.

![submodule](/img/submodule.png)

---

## Submodule 설정하기

### 1) Submodule 추가
다음 명령어로 서브모듈을 추가하고, `.gitmodules` 파일이 생성됩니다.

```bash
git submodule add [서브모듈 원격 저장소 URL] [서브모듈 로컬 저장소 경로]
```

**예제)**
```bash
git submodule add https://github.com/example/test-submodule.git test-submodule
```

생성된 `.gitmodules` 파일 예:
```text
[submodule "test-submodule"]
    path = test-submodule
    url = https://github.com/example/test-submodule.git
```

---

### 2) Submodule 상태 확인
서브모듈의 참조 커밋 상태를 확인하려면 다음 명령어를 사용합니다.

```bash
git submodule status
```

출력 예제:
```text
-423423c12355d68def56 test-submodule-common (heads/main)
```

---

### 3) 서브모듈 초기화
서브모듈의 데이터를 가져오고, 특정 커밋 상태로 업데이트하려면 다음 명령어를 실행합니다.

```bash
git submodule update --init --recursive
```

---

## Submodule 의 장단점

### 장점
1. 여러 프로젝트에서 공통 코드를 재사용하고 효율적으로 관리가 가능.
2. 독립적인 버전 관리가 이루어져 메인 프로젝트와 별개로 상태 유지.
3. 서브모듈 프로젝트의 크기를 가볍게 유지.

### 단점
| 문제점                                          | 해결 방법 또는 주의 사항                                  |
|------------------------------------------------|---------------------------------------------------------|
| 참조 커밋 관리가 필요한 복잡성                  | 메인 저장소와 서브모듈 간 동기화를 수시로 확인해야 함       |
| 여러 프로젝트가 동일 서브모듈을 커밋 시 충돌 가능 | 작업 전 최신 상태를 반영하고 신중히 적용해야 함           |
| 빌드, 배포 중 서브모듈 초기화 누락               | `git submodule update --init --recursive` 실행 자동화     |

---

## 결론
Git Submodule은 공통 코드를 여러 프로젝트에서 재사용할 때 강력한 도구가 될 수 있습니다.  
하지만 관리와 동기화가 복잡할 수 있는 만큼, 서브모듈이 팀과 프로젝트 구조에 적합한지 신중히 검토 후 사용해야 합니다.
