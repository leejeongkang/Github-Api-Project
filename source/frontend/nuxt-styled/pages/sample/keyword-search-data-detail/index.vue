<template lang="html">
  <div class="contents-wrap">
    <h2 class="hidden">검색 데이터 상세</h2>
    <div class="contents-top">
      <div class="contents-top__breadcrumb">
        <group-breadcrumb></group-breadcrumb>
        <div class="contents-top__options">
          <div class="data-options">
            <base-button class="button--sm button--secondary">
              <span class="button__text">URL 복사</span>
            </base-button>
            <base-button class="button--icon button--link button--sm data-options__tooltip">
              <svg-icon class="svg-icon data-options__icon" name="share" aria-hidden="true"></svg-icon>
              <div class="tooltip-studio tooltip-studio--light tooltip-studio--bottom-right" role="tooltip" style="display: none">
                <span class="tooltip-studio__arrow"></span>
                <div class="tooltip-studio__inner">
                  <div class="h-group">
                    <base-button class="button button--link button--icon" title="트위터로 공유하기">
                      <svg-icon class="svg-icon company-group__icon" name="global" aria-hidden="true"></svg-icon>
                    </base-button>
                    <base-button class="button button--link button--icon" title="트위터로 공유하기">
                      <svg-icon class="svg-icon company-group__icon" name="global" aria-hidden="true"></svg-icon>
                    </base-button>
                  </div>
                </div>
              </div>
            </base-button>
            <base-button class="button--icon button--link button--sm data-options__tooltip">
              <svg-icon class="svg-icon data-options__icon" name="bookmark" aria-hidden="true"></svg-icon>
              <div class="tooltip-studio tooltip-studio--light tooltip-studio--bottom-right" role="tooltip" style="display: none">
                <span class="tooltip-studio__arrow"></span>
                <div class="tooltip-studio__inner">
                  <span class="tooltip-studio__text">관심데이터 추가</span>
                </div>
              </div>
            </base-button>
          </div>
        </div>
      </div>
      <div class="subject">
        <div class="subject__wrap">
          <div class="subject__title-wrap">
            <h3 class="subject__title">데이터 상세</h3>
          </div>
        </div>
      </div>
    </div>
    <div class="contents">
      <div class="contents__inner">
        <div class="contents__product-information">
          <div class="data-box">
            <div class="data-box__inner">
              <div class="data-box__visual">
                <svg-icon class="svg-icon" name="map-shape" aria-hidden="true"></svg-icon>
              </div>
              <div class="data-box__information">
                <div class="data-box__top-content">
                  <div class="badges">
                    <base-badge class="badge--green">
                      <span class="badge__label">내부</span>
                    </base-badge>
                    <base-badge class="badge--red">
                      <span class="badge__label">자동차 부품</span>
                    </base-badge>
                  </div>
                  <div class="company-group">
                    <svg-icon class="svg-icon company-group__icon" name="global" aria-hidden="true"></svg-icon>
                    <span class="company-group__text">도로교통공단</span>
                  </div>
                </div>
                <div class="data-box__content">
                  <strong class="data-box__title"> 도로교통공사 결빙사고 다발지역 </strong>
                  <p class="data-box__description">
                    노면 상태가 '서리/결빙'인 교통사고에 대한 사고다발지역 정보
                    <br />
                    반경 200m에서 결빙사고가 3건 이상 일어난 지점으로, 결찰청 최종 선정 결과 안전을 위해 시설 개선이 필요한 지역 자체 선정 등
                  </p>
                </div>
                <div class="data-box__bottom-content">
                  <div class="data-box__details">
                    <div class="data-box__details-group">
                      <dl>
                        <dt>수정일</dt>
                        <dd>2021-08-20</dd>
                      </dl>
                      <dl>
                        <dt>등록일</dt>
                        <dd>2021-08-20</dd>
                      </dl>
                    </div>
                    <div class="data-box__details-group">
                      <dl>
                        <dt>
                          <svg-icon class="svg-icon" name="download" aria-hidden="true"></svg-icon>
                          <span class="hidden">다운로드 수</span>
                        </dt>
                        <dd>1,500</dd>
                        <dt>
                          <svg-icon class="svg-icon" name="eye" aria-hidden="true"></svg-icon>
                          <span class="hidden">조회수</span>
                        </dt>
                        <dd>1,500</dd>
                      </dl>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="contents__formbox">
          <table class="formbox formbox--bg">
            <caption class="hidden">
              상세내용
            </caption>
            <colgroup>
              <col style="width: 150px" />
              <col style="width: auto" />
              <col style="width: 150px" />
              <col style="width: auto" />
            </colgroup>
            <tbody>
              <tr v-for="(item, index) in tableLow" :key="index">
                <th scope="row">{{ item.title1 }}</th>
                <td>{{ item.content1 }}</td>
                <th scope="row">{{ item.title2 }}</th>
                <td>{{ item.content2 }}</td>
              </tr>
            </tbody>
          </table>
          <strong class="contents__formbox-title">데이터 정보</strong>
          <table class="formbox formbox--bg">
            <caption class="hidden">
              상세내용
            </caption>
            <colgroup>
              <col style="width: 150px" />
              <col style="width: auto" />
              <col style="width: 150px" />
              <col style="width: auto" />
            </colgroup>
            <tbody>
              <tr v-for="(item, index) in tableLow2" :key="index">
                <th scope="row">{{ item.title1 }}</th>
                <td>{{ item.content1 }}</td>
                <th scope="row">{{ item.title2 }}</th>
                <td>{{ item.content2 }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>
<script type="text/javascript">
import BaseRadio from "@component/styled/atoms/base-radio/base-radio";
import BaseTag from "@component/styled/atoms/base-tag/base-tag";
import BaseButton from "@component/styled/atoms/base-button/base-button";
import BaseBadge from "@component/styled/atoms/base-badge/base-badge";
import BaseCheckbox from "@component/styled/atoms/base-checkbox/base-checkbox";
import GroupTab from "@component/styled/molecules/group-tab/group-tab";
import GroupBreadcrumb from "@component/styled/molecules/group-breadcrumb/group-breadcrumb";
import SearchList from "@organisms/search-list/search-list.vue";
import SearchInputField from "@organisms/search-input-field/search-input-field.vue";
import { mapGetters } from "vuex";

export default {
  name: "Index",
  layout: "sample/sample",
  async asyncData({ store }) {
    await store.dispatch("sample/keyword-search/getContents");
  },
  computed: {
    ...mapGetters({
      contents: "sample/keyword-search/contents"
    })
  },
  data() {
    return {
      tableLow: [
        { title1: "제공기관(데이터 제공처)", content1: "도로교통공사", title2: "관리부서", content2: "데이터융합처" },
        { title1: "담당자", content1: "홍길동", title2: "관리부서 전화번호", content2: "033-749-5266" }
      ],

      tableLow2: [
        { title1: "카테고리 (분류체계)", content1: "자동차제조>스마트팩토리", title2: "라이선스", content2: "국토교통부43개" },
        { title1: "데이터 유형", content1: "데이터셋", title2: "사용언어", content2: "한국어" },
        { title1: "카테고리 (분류체계)", content1: "자동차제조>스마트팩토리", title2: "라이선스", content2: "국토교통부43개" },
        { title1: "데이터 유형", content1: "데이터셋", title2: "사용언어", content2: "한국어" },
        { title1: "카테고리 (분류체계)", content1: "자동차제조>스마트팩토리", title2: "라이선스", content2: "국토교통부43개" },
        { title1: "데이터 유형", content1: "데이터셋", title2: "사용언어", content2: "한국어" }
      ]
    };
  },
  components: {
    BaseRadio,
    BaseButton,
    BaseBadge,
    BaseTag,
    BaseCheckbox,
    GroupTab,
    GroupBreadcrumb,
    SearchList,
    SearchInputField
  }
};
</script>

<style lang="scss" scoped>
@import "./index.scss";
</style>
