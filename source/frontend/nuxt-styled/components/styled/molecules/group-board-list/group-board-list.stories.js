import StoriesContainer from "@component/stories-container.vue";
import GroupBoardList from './group-board-list.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 게시판 - 목록',
  components: GroupBoardList,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시용) Table </h2><story /></div>' })],
};

const Template = (args, {argTypes}) => {
  return {
    props: Object.keys(argTypes),
    components: {StoriesContainer, GroupBoardList},
    template:
      "<StoriesContainer>" +
      `<h4 style="margin-bottom: 4px; margin-bottom: 12px; font-size: 16px; color: #666;">${args.title}</h4>` +
      `
        <GroupBoardList theme-class="${args.themeClass}" mobileClass="${
        args.mobileClass
      }" name="${
        args.tableName
      }" v-bind="$props">
        </GroupBoardList>
    ` +
      "</StoriesContainer>",
  };
};

export const Default = Template.bind({});
Default.args = {
  title: "목록형(공지) - 모바일 변형",
  tableName: "tableBasic",
  themeClass: "",
  mobileClass: "",
};

export const NotDefomation = Template.bind({});
NotDefomation.args = {
  title: "목록형(공지) - 모바일 기본 테이블 형태 유지",
  tableName: "tableBasic",
  themeClass: "mob-tbl",
  mobileClass: "mobile-show",
};
