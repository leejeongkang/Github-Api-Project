<template lang="html">
  <div class="contents-wrap">
    <h2 class="hidden">데이터 등록</h2>
    <div class="contents-top">
      <div class="contents-top__breadcrumb">
        <group-breadcrumb></group-breadcrumb>
      </div>
      <div class="subject">
        <div class="subject__wrap">
          <div class="subject__title-wrap">
            <h3 class="subject__title">데이터 등록</h3>
            <p class="subject__desc">표준데이터 관리체계를 기반으로 한 단계별 등록을 쉽게 하실 수 있습니다.</p>
          </div>
        </div>
      </div>
    </div>

    <div class="contents">
      <div class="contents__formbox">
        <table class="formbox">
          <caption class="hidden">
            데이터 등록
          </caption>
          <colgroup>
            <col style="width: 200px" />
            <col style="width: auto" />
          </colgroup>
          <tbody>
            <tr>
              <th scope="row">카테고리(분류)<em class="text-emphasis">*</em></th>
              <td>
                <div class="open-popup-group">
                  <base-button class="button button--lg button--tertiary open-popup-group__open-button">
                    <div class="button__text">팝업 Open</div>
                  </base-button>
                  <base-button class="button button--lg button--tertiary" title="초기화">
                    <span class="button__text"> 카테고리 설정 </span>
                  </base-button>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">데이터명(제목)<em class="text-emphasis">*</em></th>
              <td>
                <div class="open-popup-group">
                  <base-button class="button button--lg button--tertiary open-popup-group__open-button">
                    <div class="button__text">팝업 Open</div>
                  </base-button>
                  <base-button class="button button--lg button--tertiary" title="초기화">
                    <span class="button__text"> 중복조회 </span>
                  </base-button>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">데이터 설명<em class="text-emphasis">*</em></th>
              <td>
                <base-textarea></base-textarea>
              </td>
            </tr>
            <tr>
              <th scope="row">제공기관(제공처)<em class="text-emphasis">*</em></th>
              <td>
                <div class="open-popup-group">
                  <base-button class="button button--lg button--tertiary open-popup-group__open-button">
                    <div class="button__text">팝업 Open</div>
                  </base-button>
                  <base-button class="button button--lg button--tertiary" title="초기화">
                    <span class="button__text"> 검색 </span>
                  </base-button>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">관리부서<em class="text-emphasis">*</em></th>
              <td>
                <base-input class="text-input--lg contents__formbox-text-input" placeholder="입력해 주세요."></base-input>
              </td>
            </tr>
            <tr>
              <th scope="row">관리부서 전화번호</th>
              <td>
                <base-input class="text-input--lg contents__formbox-text-input" placeholder="입력해 주세요."></base-input>
              </td>
            </tr>
            <tr>
              <th scope="row">담당자명</th>
              <td>
                <base-input class="text-input--lg contents__formbox-text-input" placeholder="입력해 주세요."></base-input>
              </td>
            </tr>
            <tr>
              <th scope="row">사용 언어<em class="text-emphasis">*</em></th>
              <td>
                <div class="contents__formbox-select">
                  <base-select class="select--lg">
                    <template v-slot:title>
                      <span class="select-selector__title">한국어</span>
                    </template>
                    <template v-slot:list>
                      <li class="select-container__item">
                        <button class="select-container__button" type="button" role="option">
                          <span class="select-container__text">한국어</span>
                        </button>
                      </li>
                      <li class="select-container__item">
                        <button class="select-container__button" type="button" role="option">
                          <span class="select-container__text">영어</span>
                        </button>
                      </li>
                      <li class="select-container__item">
                        <button class="select-container__button" type="button" role="option">
                          <span class="select-container__text">중국어</span>
                        </button>
                      </li>
                    </template>
                  </base-select>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">데이터 갱신 추가 <em class="text-emphasis">*</em></th>
              <td>
                <div class="contents__formbox-select">
                  <base-select class="select--lg">
                    <template v-slot:title>
                      <span class="select-selector__title">주</span>
                    </template>
                    <template v-slot:list>
                      <li class="select-container__item">
                        <button class="select-container__button" type="button" role="option">
                          <span class="select-container__text">일</span>
                        </button>
                      </li>
                      <li class="select-container__item">
                        <button class="select-container__button" type="button" role="option">
                          <span class="select-container__text">주</span>
                        </button>
                      </li>
                      <li class="select-container__item">
                        <button class="select-container__button" type="button" role="option">
                          <span class="select-container__text">분기</span>
                        </button>
                      </li>
                    </template>
                  </base-select>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">저작권</th>
              <td>
                <div class="checkboxs">
                  <base-checkbox class="checkbox--lg">
                    <template v-slot:label> 제 3자 권리포함 </template>
                  </base-checkbox>
                  <base-checkbox class="checkbox--lg">
                    <template v-slot:label> 공공저작물 </template>
                  </base-checkbox>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">라이선스</th>
              <td>
                <base-input class="text-input--lg contents__formbox-text-input" placeholder="입력해 주세요."></base-input>
              </td>
            </tr>
            <tr>
              <th scope="row">랜딩페이지 URL<em class="text-emphasis">*</em></th>
              <td>
                <base-input class="text-input--lg contents__formbox-text-input" placeholder="입력해 주세요."></base-input>
              </td>
            </tr>
            <tr>
              <th scope="row">키워드<em class="text-emphasis">*</em></th>
              <td>
                <base-input class="text-input--lg contents__formbox-text-input" placeholder="입력해 주세요."></base-input>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="contents__formbox">
        <div class="contents__top-bar">
          <strong class="contents__title"> 분석 권한 </strong>
        </div>
        <table class="formbox formbox--bg">
          <caption class="hidden">
            상세내용
          </caption>
          <colgroup>
            <col style="width: 200px" />
            <col style="width: auto" />
            <col style="width: 200px" />
            <col style="width: auto" />
          </colgroup>
          <tbody>
            <tr>
              <th scope="row">분석 권한</th>
              <td>
                <div class="h-group">
                  <base-checkbox class="checkbox--lg">
                    <template v-slot:label> 전체 </template>
                  </base-checkbox>
                  <div class="open-popup-group">
                    <base-button class="button button--lg button--tertiary open-popup-group__open-button">
                      <div class="button__text">팝업 Open</div>
                    </base-button>
                    <base-button class="button button--lg button--tertiary" title="초기화">
                      <span class="button__text"> 중복조회 </span>
                    </base-button>
                  </div>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="contents__formbox">
        <div class="contents__top-bar">
          <strong class="contents__title"> 파일 업로드 </strong>
          <p class="contents__text">등록 파일에 휴대전화번호, 주민등록번호 등 개인 정보가 포함되어 있으면 업로드 불가합니다.</p>
        </div>
        <div class="contents__file-upload">
          <base-button class="button--support button--lg">
            <span class="button__text">+데이터(파일)업로드</span>
          </base-button>
          <base-button class="button--support button--lg">
            <span class="button__text">데이터서비스(Link)</span>
          </base-button>
          <base-button class="button--support button--lg">
            <span class="button__text">마이드라이브에서 파일선택</span>
          </base-button>
        </div>
        <div class="contents__guide">
          <p class="contents__guide-text">* 샘플데이터는 5메가 이내의 csv, excel만 등록이 가능합니다.</p>
          <base-button class="contents__guide-button button--secondary">
            <span class="button__text">샘플 데이터 추가</span>
          </base-button>
        </div>
        <table class="formbox formbox--bg">
          <caption class="hidden">
            상세내용
          </caption>
          <tbody>
            <tr>
              <th scope="row">등록된 파일이 없습니다. 파일추가 버튼을 클릭해서 파일을 등록하세요.</th>
            </tr>
          </tbody>
        </table>
        <table class="formbox formbox--bg">
          <caption class="hidden">
            상세내용
          </caption>
          <colgroup>
            <col style="width: 100px" />
            <col style="width: auto" />
          </colgroup>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>
                <div class="file-attach-result">
                  <span class="file-attach-result__text"> 결빙사고 다발지역1.csv </span>
                  <base-button class="button button--lg button--link button--icon" title="초기화">
                    <svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon>
                  </base-button>
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>
                <div class="file-attach-result">
                  <span class="file-attach-result__text"> 스쿠터 사고다발지역을 제한구역으로.csv </span>
                  <base-button class="button button--lg button--link button--icon" title="초기화">
                    <svg-icon class="svg-icon" name="close" aria-hidden="true"></svg-icon>
                  </base-button>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
        <table class="formbox formbox--bg">
          <caption class="hidden">
            상세내용
          </caption>
          <tbody>
            <tr>
              <th scope="row">
                <dl>
                  <dt class="hidden">URl 입력</dt>
                  <dd><base-input class="text-input--lg" placeholder="입력해 주세요."></base-input></dd>
                </dl>
              </th>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>
<script type="text/javascript">
import GroupBreadcrumb from "@component/styled/molecules/group-breadcrumb/group-breadcrumb";
import BaseInput from "@component/styled/atoms/base-input/base-input";
import BaseTextarea from "@component/styled/atoms/base-textarea/base-textarea";
import BaseButton from "@component/styled/atoms/base-button/base-button";
import BaseSelect from "@component/styled/atoms/base-select/base-select";
import BaseCheckbox from "@component/styled/atoms/base-checkbox/base-checkbox";

export default {
  name: "Index",
  layout: "sample/sample",
  computed: {},
  components: {
    BaseCheckbox,
    BaseSelect,
    BaseTextarea,
    BaseInput,
    BaseButton,
    GroupBreadcrumb
  }
};
</script>

<style lang="scss" scoped>
@import "./index.scss";
</style>
