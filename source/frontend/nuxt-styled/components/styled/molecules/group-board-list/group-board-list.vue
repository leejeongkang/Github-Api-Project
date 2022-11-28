<template lang="html">
  <table class="board-list" :class="themeClass">
    <caption class="hidden">@@@@ 게시판입니다.</caption>
    <colgroup>
      <col style="width:80px">
      <col style="width:100px" :class="mobileClass">
      <col :class="mobileClass">
      <col style="width:100px">
      <col style="width:120px">
    </colgroup>
    <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col" :class="mobileClass">분류</th>
      <th scope="col" :class="mobileClass">제목</th>
      <th scope="col">조회수</th>
      <th scope="col">등록일자</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(item, index) in tableList" :key="index">
      <td>{{ item.num }}</td>
      <td :class="mobileClass">{{ item.cate }}</td>
      <td class="mobile-show text-left">
        <a href="#none"><span class="data-label">{{ item.cate }}[이벤트]</span>{{ item.title }}
        </a>
        <!-- 첨부파일 아이콘 -->
        <svg-icon class="svg-icon" name="link" aria-hidden="true"></svg-icon>
        <!-- 새글 아이콘 -->
        <BaseBadge class="badge--sm badge--teal"><span class="badge__label">NEW</span></BaseBadge>

        <div class="inner-mobile">
          <div class="data-info">
            <dl>
              <dt>등록일</dt>
              <dd>{{ item.date }}</dd>
            </dl>
          </div>
        </div>
      </td>
      <td>{{ item.hit }}</td>
      <td>{{ item.date }}</td>
    </tr>
    </tbody>
  </table>
</template>

<script type="text/javascript">
import BaseBadge from "@component/styled/atoms/base-badge/base-badge";

export default {
  name: "GroupBoardList",
  props: {
    themeClass: {
      type: String
    },
    mobileClass: {
      type: String
    }
  },
  components: {
    BaseBadge
  },
  data() {
    return {
      tableList: [
        {
          num: '100',
          cate: '이벤트',
          title: '2021년 당첨자 공지 2021년 공공데이터 신규개발 수요조사 커피쿠폰 증정 이벤트 당첨자',
          hit: '1',
          date: '2021-06-23'
        },
        {num: '99', cate: '점검', title: '시스템 점검', hit: '20', date: '2021-06-23'},
        {num: '15', cate: '공지', title: 'mobile-show : 분류 + 제목 + 등록일자', hit: '115', date: '2021-06-23'},
        {
          num: '1',
          cate: '이벤트',
          title: '국군의 조직과 편성은 법률로 정한다. 대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.',
          hit: '1',
          date: '2021-06-23'
        },
      ]
    };
  }
};
</script>

<style lang="scss" scoped>
@import "./group-board-list";
</style>
