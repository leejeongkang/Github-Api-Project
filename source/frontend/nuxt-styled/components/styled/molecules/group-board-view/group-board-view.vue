<template lang="html">
  <div class="board-view">
    <div class="board-view__head mobile-show"><!-- PC,M에서 보이고 M에서는 구조 변경됨 -->
      <strong class="board-view__title"><span class="data-label">[데이터]</span>산림사업용 묘목 가격 OpenAPI 문의</strong>
      <!-- inner-mobile : 모바일에서만 나오는 영역 -->
      <div class="board-view__desc inner-mobile">
        <div class="data-info">
          <dl>
            <dt>작성일</dt>
            <dd>2021-06-23</dd>
          </dl>
        </div>
        <div class="board-view__desc-answer">
          <BaseBadge class="badge badge--teal"><span class="badge__label">답변완료</span></BaseBadge>
        </div>
      </div>
      <!-- //inner-mobile : 모바일에서만 나오는 영역 -->
    </div>
    <div class="board-view__body">
      <table class="formbox formbox--ty1">
        <caption>문의하기 상세 게시판입니다.</caption>
        <colgroup>
          <col style="width:100px">
          <col style="width:180px">
          <col style="width:100px">
          <col style="width:140px">
          <col style="width:100px">
          <col style="width:140px">
          <col style="width:100px">
          <col>
        </colgroup>
        <tbody>
        <tr class="pc-only"><!-- pc-only 추가 -->
          <th scope="row">문의유형</th>
          <td>데이터</td>
          <th scope="row">작성자</th>
          <td>홍**</td>
          <th scope="row">작성일</th>
          <td>2021-10-03</td>
          <th scope="row">상태</th>
          <td>
            <BaseBadge class="badge badge--teal"><span class="badge__label">답변완료</span></BaseBadge>
          </td>
        </tr>
        <tr>
          <td colspan="8">
            <div class="board-view__content">
              안녕하세요. 산림사업용 묘목 가격 OpenAPI 문의 드리고자 합니다. <br>
              해당 API의 업데이트 주기가 년간이라고 되어 있는데 데이터가 2015년 까지만 있습니다.<br><br>
              해당 API는 앞으로도 데이터가 생기지 않는 건가요?
            </div>
          </td>
        </tr>
        <tr>
          <th scope="row">첨부파일</th>
          <td colspan="7" class="border-view__file">
            <ul class="board-view__file-list">
              <li>
                <a href="#none" title="첨부파일다운로드">
                  <!-- 첨부파일 아이콘 -->
                  <svg-icon class="svg-icon" name="link" aria-hidden="true"></svg-icon>
                  [포스터] 2020년 스마트농업
                  빅데이터 활용 우수사례22222.jpg</a>
              </li>
              <li>
                <a href="#none" title="첨부파일다운로드">
                  <!-- 첨부파일 아이콘 -->
                  <svg-icon class="svg-icon" name="link" aria-hidden="true"></svg-icon>
                  2020년 스마트농업 빅데이터
                  활용 33333333333333333333.jpg</a>
              </li>
            </ul>
          </td>
        </tr>
        <tr class="pc-only">
          <th scope="row">처리상태</th>
          <td colspan="7">
            <BaseBadge class="badge badge--teal"><span class="badge__label">답변완료</span></BaseBadge>
          </td>
        </tr>
        <tr class="board-view__reply">
          <th scope="row">답변</th>
          <td colspan="7">
            <div class="v-group">
              <div class="data-info">
                <dl>
                  <dd class="mobile-show">2021-10-03</dd>
                </dl>
              </div>
              <!-- cms영역 -->
              <div class="board-view__cmt">
                등록한 내용 대로 들어가나요?? <br>
                안녕하세요. <br>
                농림축산식품부 공공데이터 포털 운영팀 입니다.<br><br>

                요청하신 묘목가격정보는 산림청과 실시간 연계가 되지 않아
                현행화 대상으로 작업중에 있습니다.<br>

                번거로우시더라도 산림청 묘목가격정보 페이지에서 2017년까지 최신 정보를
                다운로드 받아 활용해주시기 바랍니다.<br>
                http://www.forest.go.kr/newkfsweb/html/HtmlPage.do?pg=/resource/resource_020311_2016_con01.html&amp;mn=KFS_18_03_04&amp;orgId=kfsv
              </div>
              <!-- //cms영역 -->
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <!-- //board-body-->
  </div>
</template>

<script type="text/javascript">
import BaseBadge from "@component/styled/atoms/base-badge/base-badge";

export default {
  name: "GroupBoardView",
  extends: {},
  components: {
    BaseBadge
  },
  watch: {},

};
</script>

<style lang="scss" scoped>
@import "./group-board-view.scss";
</style>
