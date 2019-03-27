/**
 * 非空检查
 * @param param   : 需要校验的参数
 * @param warnStr : 提示字符串
 */
function notEmpty(param, warnStr) {
    if (isBlank(param)) {
        fail(warnStr);
    }
}

