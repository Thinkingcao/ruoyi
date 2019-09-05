package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysTest;
import com.ruoyi.system.service.ISysTestService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测试Controller
 * 
 * @author ruoyi
 * @date 2019-09-06
 */
@Controller
@RequestMapping("/system/test")
public class SysTestController extends BaseController
{
    private String prefix = "system/test";

    @Autowired
    private ISysTestService sysTestService;

    @RequiresPermissions("system:test:view")
    @GetMapping()
    public String test()
    {
        return prefix + "/test";
    }

    /**
     * 查询测试列表
     */
    @RequiresPermissions("system:test:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTest sysTest)
    {
        startPage();
        return getDataTable(sysTestService.list(new QueryWrapper<>()));
    }

    /**
     * 导出测试列表
     */
    @RequiresPermissions("system:test:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysTest sysTest)
    {
        List<SysTest> list = sysTestService.list(new QueryWrapper<>());
        ExcelUtil<SysTest> util = new ExcelUtil<SysTest>(SysTest.class);
        return util.exportExcel(list, "test");
    }

    /**
     * 新增测试
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存测试
     */
    @RequiresPermissions("system:test:add")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysTest sysTest)
    {
        return toAjax(sysTestService.save(sysTest));
    }

    /**
     * 修改测试
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysTest sysTest = sysTestService.getById(id);
        mmap.put("sysTest", sysTest);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试
     */
    @RequiresPermissions("system:test:edit")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysTest sysTest)
    {
        return toAjax(sysTestService.updateById(sysTest));
    }

    /**
     * 删除测试
     */
    @RequiresPermissions("system:test:remove")
    @Log(title = "测试", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysTestService.removeByIds(Arrays.asList(Convert.toStrArray(ids))));
    }
}
